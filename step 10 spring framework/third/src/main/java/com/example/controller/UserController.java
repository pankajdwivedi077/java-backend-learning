package com.example.controller;

import com.example.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String user){
        userService.addUser(user);
        System.out.println("user added");
    }

    public void listUsers(){
        List<String> users = userService.getAllUsers();
        System.out.println("All Users " + users);
    }

}
