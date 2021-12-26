package com.juniper.onlinesavdo.payload.responce;

import com.juniper.onlinesavdo.payload.request.ProductReqDto;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductResDto extends ProductReqDto {
    private UUID id;
}
