package com.example.step32SpringSecurity.controller;

import com.example.step32SpringSecurity.entity.Role;
import com.example.step32SpringSecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping()
    public ResponseEntity<String> addRole(@RequestBody Role role){
      roleService.addRole(role);
     return ResponseEntity.ok("its done bro");
    }

}
