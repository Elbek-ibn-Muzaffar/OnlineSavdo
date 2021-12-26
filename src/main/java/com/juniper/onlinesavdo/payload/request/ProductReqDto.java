package com.juniper.onlinesavdo.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductReqDto {

    private String productname;

    private String size;

    private String about;

    private BigDecimal cost;

    private String hashid;

    private long partId;
}
