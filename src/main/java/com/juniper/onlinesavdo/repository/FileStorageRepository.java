package com.juniper.onlinesavdo.repository;



import com.juniper.onlinesavdo.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage,Long> {
    @Query("select f from FileStorage f where f.hashId= :hashid")
    FileStorage findByhashid(@Param("hashid") String hashId);



}
