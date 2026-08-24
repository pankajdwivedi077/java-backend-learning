package com.example.step28JPA.controller;

import com.example.step28JPA.model.Student;
import com.example.step28JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

//    @PostMapping("/{deptId}")
@PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam Long deptId){
        studentService.create(student, deptId);
        return ResponseEntity.ok("Done");
    }

}
