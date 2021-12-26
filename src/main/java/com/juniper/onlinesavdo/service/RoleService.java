package com.juniper.onlinesavdo.service;

import com.juniper.onlinesavdo.entity.Roles;
import com.juniper.onlinesavdo.payload.request.RoleDto;
import com.juniper.onlinesavdo.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    ModelMapper modelMapper=new ModelMapper();

    public String saveRole(RoleDto roleDto)
    {
        roleRepository.save(modelMapper.map(roleDto, Roles.class));
        return "Saqlandi";
    }
}
