package com.example.step1Devops.controller;

import com.example.step1Devops.model.Student;
import com.example.step1Devops.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
      return studentService.getAllStudent();
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student st){
        return studentService.add(st);
    }
}
