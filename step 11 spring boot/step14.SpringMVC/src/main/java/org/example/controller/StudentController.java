package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student student = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentReq);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
       Student student = studentService.getStudent(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> students = studentService.getAllStudents();
        if(students.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

}
