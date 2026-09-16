package com.example.step2security.service;

import com.example.step2security.entity.Users;
import com.example.step2security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public Users register(Users users){
       users.setPassword(encoder.encode(users.getPassword()));
       return userRepo.save(users);
    }
}
