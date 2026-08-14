package com.example.step21Aop.service;

import com.example.step21Aop.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student s){

        System.out.println("Student saved");

         return s;

    }

    public String getStudent(String s){
        System.out.println(s);
        return  s;
    }

    public int dummyMethod(){
        return  0;
    }

}
