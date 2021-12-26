package com.juniper.onlinesavdo.controller;

import com.juniper.onlinesavdo.payload.AuthRequest;
import com.juniper.onlinesavdo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/createToken")
    public ResponseEntity generateToken(@RequestBody AuthRequest authRequest) throws Exception
    {
        return ResponseEntity.ok(jwtService.createToken(authRequest));
    }
}
