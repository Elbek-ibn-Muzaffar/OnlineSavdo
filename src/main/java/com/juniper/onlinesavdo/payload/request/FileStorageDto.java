package com.juniper.onlinesavdo.payload.request;

import com.juniper.onlinesavdo.entity.Enurmations.FileStorageStatus;
import lombok.Data;

@Data
public class FileStorageDto {
    private long id;

    private String fileName;

    private String extension;

    private long fileSize;

    private String uploadPath;

    private String contentType;

    private FileStorageStatus fileStorageStatus;

    private String hashId;
}
