package com.juniper.onlinesavdo.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileStorageTemplate {
    private long id;

    private String fileName;

}
