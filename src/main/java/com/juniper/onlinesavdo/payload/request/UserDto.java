package com.juniper.onlinesavdo.payload.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private String fullname;

    private String phonenumber;

    private String password;

    private String place;

    private String regName;

}
