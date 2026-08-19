package com.example.step25SpringJdbc.controller;

import com.example.step25SpringJdbc.model.Student;
import com.example.step25SpringJdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   StudentService studentService;

   @Autowired
   public StudentController(StudentService studentService){
       this.studentService = studentService;
   }

   @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
       studentService.createStudent(student);
       return ResponseEntity.ok("Done");
   }

   @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
      List<Student> students = studentService.getAllStudents();
      return  ResponseEntity.ok(students);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
       Student student = studentService.getStudentById(id);
       return ResponseEntity.ok(student);
   }

   @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
       studentService.updateStudent(student);
       return ResponseEntity.ok("Done");
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       studentService.deleteStudent(id);
       return ResponseEntity.ok("Done");
   }

}
