package com.example.step15DTO.controller;

import com.example.step15DTO.dto.StudentRequestDTO;
import com.example.step15DTO.dto.StudentResponseDTO;
import com.example.step15DTO.dto.StudentUpdateRequestDTO;
import com.example.step15DTO.dto.StudentUpdateResponseDTO;
import com.example.step15DTO.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create
    @PostMapping("/create")
    public ResponseEntity<StudentResponseDTO> create(@Valid @RequestBody StudentRequestDTO student){
         StudentResponseDTO studentResp = studentService.createStudent(student);
         return ResponseEntity.ok(studentResp);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentUpdateResponseDTO> update(@RequestParam Long id,@RequestBody StudentUpdateRequestDTO student){
        StudentUpdateResponseDTO dto = studentService.updateStudent(id,student);
        if(dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

}
