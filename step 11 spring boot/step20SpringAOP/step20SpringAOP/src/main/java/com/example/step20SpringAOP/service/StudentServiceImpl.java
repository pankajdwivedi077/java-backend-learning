package com.example.step20SpringAOP.service;

import com.example.step20SpringAOP.dto.Student;
import com.example.step20SpringAOP.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student st){

        studentRepository.save(st);


    }

}
