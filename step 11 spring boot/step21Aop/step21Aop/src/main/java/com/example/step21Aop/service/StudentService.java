package com.example.step21Aop.service;

import com.example.step21Aop.dto.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String dummyMethod(String s){
       return s;
    }

    public Student createStudent(Student s){

        System.out.println("saved");

//        throw new RuntimeException("some error occured");

//        try{
//            throw new RuntimeException("some error occured");
//        }catch(RuntimeException e){
//            return "Saved";
//        }

//        return  "Saved";

         return s;

    }


}
