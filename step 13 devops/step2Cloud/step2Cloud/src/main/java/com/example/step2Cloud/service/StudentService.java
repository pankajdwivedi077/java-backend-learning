package com.example.step2Cloud.service;


import com.example.step2Cloud.model.Student;
import com.example.step2Cloud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student add(Student st) {
        return studentRepository.save(st);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
