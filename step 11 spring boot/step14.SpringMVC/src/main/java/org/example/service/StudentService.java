package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
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

    public Student createStudent(Student st){
        return studentRepository.save(st);
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
