package com.juniper.onlinesavdo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class TestController {

    @GetMapping("/helloadmin")
    public ResponseEntity testAdmin()
    {
        return ResponseEntity.ok("hello Admin");
    }

}
