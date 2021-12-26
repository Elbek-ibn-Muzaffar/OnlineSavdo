package com.juniper.onlinesavdo.controller;



import com.juniper.onlinesavdo.entity.FileStorage;
import com.juniper.onlinesavdo.payload.request.FileStorageTemplate;
import com.juniper.onlinesavdo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class FileStorageResource {
    private final FileStorageService fileStorageService;


    public FileStorageResource(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }
    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/upload")
    public ResponseEntity save(@RequestParam("file") MultipartFile multipartFile)
    {

//        List<FileStorage> fileStorages=fileStorageRepository.findByFileName(multipartFile.getOriginalFilename());
        return ResponseEntity.ok(fileStorageService.save(multipartFile));
    }


    //Preview

    @GetMapping("/preview/{hashId}")
    public ResponseEntity findbyhashid(@PathVariable String hashId) throws IOException
    {
        FileStorage fileStorage=fileStorageService.findByhashid(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline=\""+ URLEncoder.encode(fileStorage.getFileName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",uploadFolder,fileStorage.getUploadPath())));
    }

    @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws IOException
    {
        FileStorage fileStorage=fileStorageService.findByhashid(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment=\""+ URLEncoder.encode(fileStorage.getFileName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",uploadFolder,fileStorage.getUploadPath())));
    }

//    @DeleteMapping("/admin/delette")
//    public ResponseEntity delete(@RequestParam String hashId)
//    {
//        fileStorageService.deletebyhashid(hashId);
//        return ResponseEntity.ok("Rasm O'chirildi");
//    }

//    @DeleteMapping("/admin/deletteAll")
//    public ResponseEntity deletteAll(String d)
//    {
//        d="DRAFT";
//        fileStorageService.deleteAllDraft(d);
//        return ResponseEntity.ok("o'chdi");
//    }
}
