package com.juniper.onlinesavdo.entity;



import com.juniper.onlinesavdo.entity.Enurmations.FileStorageStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class FileStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private String extension;

    private long fileSize;

    private String uploadPath;

    private String contentType;

    @Enumerated(EnumType.STRING)
    private FileStorageStatus fileStorageStatus;


    private String hashId;


}
