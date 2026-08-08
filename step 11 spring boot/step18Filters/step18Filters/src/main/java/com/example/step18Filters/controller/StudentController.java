package com.example.step18Filters.controller;

import com.example.step18Filters.dto.StudentDTO;
import com.example.step18Filters.dto.StudentResponseDTO;
import com.example.step18Filters.entity.Student;
import com.example.step18Filters.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentDTO studentDTO){
//       studentService.createStudent(studentDTO);
        StudentResponseDTO dto = studentService.createStudent(studentDTO);
     //  return ResponseEntity.ok("done");
        return ResponseEntity.ok(dto);
    }

}
