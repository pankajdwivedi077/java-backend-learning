package com.example.step20SpringAOP.service;

import com.example.step20SpringAOP.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentService;

    @Autowired
    public LoggingDecorator(StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    @Override
    public void createStudent(Student st) {

        // logic related logic

        LoginServiceUtils.logStart("StudentServiceimpl",
                "createStudent");

        studentService.createStudent(st);

        LoginServiceUtils.logEnd("StudentServiceimpl",
                "createStudent");
    }
}
