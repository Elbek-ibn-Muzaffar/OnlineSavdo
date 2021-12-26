package com.juniper.onlinesavdo.repository;

import com.juniper.onlinesavdo.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Parts,Long> {

}
