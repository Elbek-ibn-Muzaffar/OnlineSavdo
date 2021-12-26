package com.juniper.onlinesavdo.controller;


import com.juniper.onlinesavdo.entity.Region;
import com.juniper.onlinesavdo.payload.request.RegionDto;
import com.juniper.onlinesavdo.repository.RegionRepository;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    ModelMapper modelMapper=new ModelMapper();

    @ApiOperation("saving users")
    @PostMapping("/saveAll")
    public ResponseEntity saveRegion(@RequestBody List<RegionDto> regionDto)
    {
        List<Region> regions=new ArrayList<>();

        for (int i=0; i<regionDto.size();i++)
        {
            regions.add(modelMapper.map(regionDto.get(i),Region.class));
        }

        regionRepository.saveAll(regions);
        return ResponseEntity.ok("saqlandi");
    }

    @GetMapping("/getAll")
    public List<RegionDto> getAllRegions()
    {
        List<RegionDto> regionDtos=new ArrayList<>();
        for (int i=0;i<regionRepository.findAll().size();i++)
        {
            regionDtos.add(modelMapper.map(regionRepository.findAll().get(i),RegionDto.class));
        }
        return regionDtos;
    }


}
