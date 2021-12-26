package com.juniper.onlinesavdo.controller;


import com.juniper.onlinesavdo.payload.request.RoleDto;
import com.juniper.onlinesavdo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity saveRoles(@RequestBody RoleDto roleDto)
    {
        return ResponseEntity.ok(roleService.saveRole(roleDto));
    }
}
