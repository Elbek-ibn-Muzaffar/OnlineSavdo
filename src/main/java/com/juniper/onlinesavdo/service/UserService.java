package com.juniper.onlinesavdo.service;


import com.juniper.onlinesavdo.entity.Roles;
import com.juniper.onlinesavdo.entity.Users;
import com.juniper.onlinesavdo.payload.request.UserDto;
import com.juniper.onlinesavdo.payload.request.UserReqDto;
import com.juniper.onlinesavdo.payload.responce.UserResDto;
import com.juniper.onlinesavdo.repository.RegionRepository;
import com.juniper.onlinesavdo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegionRepository regionRepository;

    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    private PasswordEncoder passwordEncoder;

    //saving user
    public String saveUser(UserDto userDto)
    {
        if (!userRepository.existsByPhonenumber(userDto.getPhonenumber()))
        {
            Roles role=new Roles();
            role.setName("ROLE_USER");
            Set<Roles> roles=new HashSet<>();
            roles.add(role);
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Users users=modelMapper.map(userDto,Users.class);
            users.setRegion(regionRepository.findByRegionname(userDto.getRegName()));
            users.setRoles(roles);
            userRepository.save(users);
            return "Saqlandi";
        }

        return "Bu User mavjud";
    }

    //saving admin
    public String saveAdmin(UserDto userDto)
    {
        Roles role=new Roles();
        role.setName("ROLE_ADMIN");
        Set<Roles> roles=new HashSet<>();
        roles.add(role);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users users=modelMapper.map(userDto,Users.class);
        users.setRegion(regionRepository.findByRegionname(userDto.getRegName()));
        users.setRoles(roles);
        userRepository.save(users);
        return "Saqlandi";
    }


    //getting all users
    public List<UserResDto> getAllUsers()
    {

        List<Users> users=userRepository.findByRolesName("ROLE_USER");
        List<UserResDto> userResDtos=new ArrayList<>();
        for (int i=0;i<users.size();i++)
        {
            UserResDto userResDto=new UserResDto();
            userResDto.setFullname(users.get(i).getFullname());
            userResDto.setPhonenumber(users.get(i).getPhonenumber());
            userResDto.setRegName(users.get(i).getRegion().getRegionname());
            userResDto.setPlace(users.get(i).getPlace());
            userResDtos.add(userResDto);

        }

        return userResDtos;
    }

    //updating user datas
    public String updateUsers(UserReqDto userReqDto)
    {
       Users users=userRepository.findByPhonenumber(userReqDto.getPhonenumber());
        userReqDto.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        modelMapper.map(userReqDto,Users.class);
        users.setPhonenumber(userReqDto.getNewPhonenunmber());
        users.setRegion(regionRepository.findByRegionname(userReqDto.getRegName()));
        userRepository.save(users);
        return "O'zgartirildi";
    }


}
