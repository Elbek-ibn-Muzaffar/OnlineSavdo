package com.juniper.onlinesavdo.repository;

import com.juniper.onlinesavdo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findByPhonenumber(String number);

    boolean existsByPhonenumber(String number);

    List<Users> findByRolesName(String name);
}
