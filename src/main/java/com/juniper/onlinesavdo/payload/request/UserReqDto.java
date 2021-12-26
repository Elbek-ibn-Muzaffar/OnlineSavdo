package com.juniper.onlinesavdo.payload.request;

import lombok.Data;

@Data
public class UserReqDto {
    private String fullname;

    private String phonenumber;

    private String newPhonenunmber;

    private String password;

    private String place;

    private String regName;
}
