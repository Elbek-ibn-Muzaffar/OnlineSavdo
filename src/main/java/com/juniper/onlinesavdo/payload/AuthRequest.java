package com.juniper.onlinesavdo.payload;

import lombok.Data;

@Data
public class AuthRequest {
    private String phonenumber;
    private String password;
}
