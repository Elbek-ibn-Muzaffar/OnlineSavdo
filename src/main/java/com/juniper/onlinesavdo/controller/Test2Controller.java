package com.juniper.onlinesavdo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class Test2Controller {

    @GetMapping("testUser")
    public ResponseEntity testUser()
    {
        return ResponseEntity.ok("hello user");
    }
}
