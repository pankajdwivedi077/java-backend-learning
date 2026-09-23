package com.example.step1Devops.service;

import com.example.step1Devops.model.Student;
import com.example.step1Devops.repository.StudentRepository;
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
