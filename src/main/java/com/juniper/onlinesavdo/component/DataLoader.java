package com.juniper.onlinesavdo.component;

import com.juniper.onlinesavdo.entity.Region;
import com.juniper.onlinesavdo.entity.Roles;
import com.juniper.onlinesavdo.entity.Users;
import com.juniper.onlinesavdo.repository.RegionRepository;
import com.juniper.onlinesavdo.repository.RoleRepository;
import com.juniper.onlinesavdo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegionRepository regionRepository;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {
            Roles roles=new Roles();
            roles.setName("ROLE_ADMIN");
            roleRepository.save(roles);

            Region region=new Region();
            region.setRegionname("Namangan");
            regionRepository.save(region);

            Users users=new Users();
            users.setFullname("Elbek Usmonjonov");
            users.setPhonenumber("+998931788058");
            users.setPassword(passwordEncoder.encode("112233"));
            users.setRegion(regionRepository.findByRegionname("Namangan"));
            users.setPlace("Pop tumani");
            users.setRoles(roleRepository.findAllByName("ROLE_ADMIN"));
            userRepository.save(users);
        }
    }
}
