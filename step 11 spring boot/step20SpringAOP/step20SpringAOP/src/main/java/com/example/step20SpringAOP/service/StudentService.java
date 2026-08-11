package com.example.step20SpringAOP.service;

import com.example.step20SpringAOP.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student st){
        System.out.println("student saved");

    }

}
