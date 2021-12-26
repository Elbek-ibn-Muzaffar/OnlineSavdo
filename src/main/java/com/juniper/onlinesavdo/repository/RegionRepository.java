package com.juniper.onlinesavdo.repository;

import com.juniper.onlinesavdo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    Region findByRegionname(String name);
}
