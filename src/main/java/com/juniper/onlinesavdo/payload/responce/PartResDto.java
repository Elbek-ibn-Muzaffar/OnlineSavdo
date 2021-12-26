package com.juniper.onlinesavdo.payload.responce;

import com.juniper.onlinesavdo.payload.request.PartsReqDto;
import lombok.Data;

@Data
public class PartResDto extends PartsReqDto {
    private long id;
}
