package com.example.step2security.service;

import com.example.step2security.entity.Users;
import com.example.step2security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public UserService(UserRepo userRepo, AuthenticationManager authenticationManager,
                       JwtService jwtService){
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Users register(Users users){
       users.setPassword(encoder.encode(users.getPassword()));
       return userRepo.save(users);
    }

    public String verify(Users user) {
        Authentication authentication =
                authenticationManager.authenticate(new
                        UsernamePasswordAuthenticationToken(user.getUsername(),
                        user.getPassword()));
       if(authentication.isAuthenticated())
           return jwtService.generateToken(user.getUsername());

       return "fail";
    }
}
