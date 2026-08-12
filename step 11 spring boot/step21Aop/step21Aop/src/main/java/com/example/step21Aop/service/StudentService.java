package com.example.step21Aop.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent(){

        System.out.println("saved");
        return  "Saved";
    }

}
