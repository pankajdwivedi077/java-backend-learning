package com.example.step12Crud.controller;

import com.example.step12Crud.entity.Student;
import com.example.step12Crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  @PostMapping("/create")
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
     Student createdSt = studentService.createStudent(student);
      System.out.println("inside controller");
     return ResponseEntity.status(HttpStatus.CREATED).body(createdSt);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id){
     Student res = studentService.getStudent(id);
     if(res == null){
         return ResponseEntity.notFound().build();
     }
     return ResponseEntity
             .status(HttpStatus.OK)
             .body(res);
  }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> res = studentService.getAllStudents();
        if(res.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student st){
        Student res = studentService.update(id, st);
        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){
      Boolean isDeleted = studentService.delete(id);
      if(!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(true);
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
      Boolean isDeleted = studentService.deleteStudentSoftly(id);
      if(!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok("Record deleted");
    }

}
