package com.juniper.onlinesavdo.service;



import com.juniper.onlinesavdo.entity.Enurmations.FileStorageStatus;
import com.juniper.onlinesavdo.entity.FileStorage;
import com.juniper.onlinesavdo.payload.request.FileStorageTemplate;
import com.juniper.onlinesavdo.repository.FileStorageRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids=new Hashids(getClass().getName(),6);
    }

    @Value("${upload.folder}")
    private String uploadFolder;

    private final Hashids hashids;

    public String save(MultipartFile multipartFile)
    {
        FileStorage fileStorage=new FileStorage();
        fileStorage.setFileName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setFileStorageStatus(FileStorageStatus.ACTIVE);
        fileStorageRepository.save(fileStorage);

        Date now=new Date();
        File uploadFolder= new File(String.format("%s/upload_file/%d/%d/%d/",this.uploadFolder,1900+now.getYear(),1+now.getMonth(),now.getDate()));



        if(!uploadFolder.exists()&&uploadFolder.mkdirs())
        {
            System.out.println("Aytilgan papkalar yaratildi");
        }

        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        fileStorage.setUploadPath(String.format("upload_file/%d/%d/%d/%s.%s",1900+now.getYear(),1+now.getMonth(),now.getDate()
                ,fileStorage.getFileName() , fileStorage.getExtension()));
        fileStorageRepository.save(fileStorage);
        uploadFolder=uploadFolder.getAbsoluteFile();
        File file=new File(uploadFolder, String.format("%s.%s",fileStorage.getFileName(),fileStorage.getExtension()));

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStorage.getHashId();
    }

    @Transactional(readOnly = true)
    public FileStorage findByhashid(String hashid)
    {
        return fileStorageRepository.findByhashid(hashid);
    }

//    @Scheduled(cron = "0 0 0 * * *")
//    public void deleteAllDraft(String status)
//    {
//        List<FileStorage> fileStorages=fileStorageRepository.findAllByFileStorageStatus(status);
//        fileStorages.forEach(fileStorage -> {
//            deletebyhashid(fileStorage.getHashId());
//        });
//    }

    public void deletebyhashid(String hashId)
    {
        FileStorage fileStorage=fileStorageRepository.findByhashid(hashId);
        File file = new File(String.format("%s/%s",this.uploadFolder,fileStorage.getUploadPath()));
        if(file.delete())
        {
            fileStorageRepository.delete(fileStorage);
        }

    }

    private String getExt(String fileName)
    {
        String ext=null;

        if (fileName!=null && !fileName.isEmpty())
        {
            int dot=fileName.lastIndexOf('.');
            if(dot>0&&dot<=fileName.length()-2)
            {
                ext=fileName.substring(dot+1);
            }
        }

        return ext;
    }

//    public List<FileStorageTemplate> getAllId()
//    {
//        return fileStorageRepository.getAllIdAndFileName();
//    }



}
