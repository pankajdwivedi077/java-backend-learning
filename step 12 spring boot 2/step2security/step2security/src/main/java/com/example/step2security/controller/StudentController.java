package com.example.step2security.controller;

import com.example.step2security.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "bell", 99),
            new Student(2, "aiz", 100)
    ));

    @GetMapping()
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student st){
        students.add(st);
        return  st;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
