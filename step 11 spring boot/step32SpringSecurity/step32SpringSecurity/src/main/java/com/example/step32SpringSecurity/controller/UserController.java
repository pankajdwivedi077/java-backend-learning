package com.example.step32SpringSecurity.controller;

import com.example.step32SpringSecurity.dto.UserRegisterRequestDto;
import com.example.step32SpringSecurity.dto.UserRegisterResponseDto;
import com.example.step32SpringSecurity.service.Authservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Authservice authservice;

    @Autowired
    public UserController(Authservice authservice){
        this.authservice = authservice;
    }

    @GetMapping()
    public String sayHello(){

        return "hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>
    register(@RequestBody UserRegisterRequestDto register){
      UserRegisterResponseDto responseDto = authservice.registerUser(register);
      return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }

}
