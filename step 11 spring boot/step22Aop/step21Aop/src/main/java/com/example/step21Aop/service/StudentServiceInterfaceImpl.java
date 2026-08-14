package com.example.step21Aop.service;

import com.example.step21Aop.dto.Student;

public class StudentServiceInterfaceImpl implements StudentServiceInterface{
    @Override
    public Student createStudent(Student s) {
        System.out.println("student saved");
        return s;
    }
}
