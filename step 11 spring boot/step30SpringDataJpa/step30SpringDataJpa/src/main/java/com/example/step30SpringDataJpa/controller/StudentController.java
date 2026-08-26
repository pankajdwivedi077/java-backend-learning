package com.example.step30SpringDataJpa.controller;

import com.example.step30SpringDataJpa.entity.Student;
import com.example.step30SpringDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student st){
        studentService.createStudent(st);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student = studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getAllStudent(@PathVariable String name){
        List<Student> students = studentService.fetchAll(name);
        return ResponseEntity.ok(students);
    }

}
