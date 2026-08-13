package com.example.step21Aop.service;

import com.example.step21Aop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String getStudent(){
       String s = "All Student Data";
        System.out.println(s);
        return  s;
    }

    public Student createStudent(Student s){

        System.out.println("Student saved");

         return s;

    }


}
