package com.juniper.onlinesavdo.controller;


import com.juniper.onlinesavdo.payload.request.UserDto;
import com.juniper.onlinesavdo.payload.request.UserReqDto;
import com.juniper.onlinesavdo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUsers(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @ApiOperation("saving admin")
    @PostMapping("/admin/save")
    public ResponseEntity saveAdmin(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.saveAdmin(userDto));
    }

    @ApiOperation("Barcha Userlarni chiqarib beradi")
    @GetMapping("/admin/getAllUser")
    public ResponseEntity getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @ApiOperation("Update datas")
    @PutMapping("/user/update")
    public ResponseEntity updateUser(@RequestBody UserReqDto userReqDto)
    {
        return ResponseEntity.ok(userService.updateUsers(userReqDto));
    }
}
