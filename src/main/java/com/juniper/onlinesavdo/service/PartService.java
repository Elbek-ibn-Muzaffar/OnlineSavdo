package com.juniper.onlinesavdo.service;

import com.juniper.onlinesavdo.entity.Parts;
import com.juniper.onlinesavdo.payload.request.PartsReqDto;
import com.juniper.onlinesavdo.payload.responce.PartResDto;
import com.juniper.onlinesavdo.repository.FileStorageRepository;
import com.juniper.onlinesavdo.repository.PartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private FileStorageRepository fileStorageRepository;

    ModelMapper modelMapper=new ModelMapper();


    //saving parts
    public String savePart(PartsReqDto partsReqDto)
    {
        Parts parts=modelMapper.map(partsReqDto,Parts.class);
        parts.setFileStorage(fileStorageRepository.findByhashid(partsReqDto.getHashid()));
        partRepository.save(parts);
        return "Saved";
    }


    //getting all parts
    public List<PartResDto> getAllParts()
    {
        List<Parts> partsList=partRepository.findAll();
        List<PartResDto> partResDtos=new ArrayList<>();

        for(int i=0; i< partsList.size();i++)
        {
            partResDtos.add(modelMapper.map(partsList.get(i),PartResDto.class));
            partResDtos.get(i).setHashid(partsList.get(i).getFileStorage().getHashId());
        }
        return partResDtos;
    }

    public String updatePart(PartResDto partResDto)
    {
        Parts parts=modelMapper.map(partResDto,Parts.class);
        parts.setFileStorage(fileStorageRepository.findByhashid(partResDto.getHashid()));
        partRepository.save(parts);
        return "Updated";
    }
}
