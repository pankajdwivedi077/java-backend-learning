package com.example.step26Hinernate.controller;

import com.example.step26Hinernate.model.Student;
import com.example.step26Hinernate.service.StudentService;
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

   @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student){
       studentService.createStudent(student);
       return ResponseEntity.ok("Done");
   }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student, id);
        return ResponseEntity.ok("Done");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Done");
    }

}
