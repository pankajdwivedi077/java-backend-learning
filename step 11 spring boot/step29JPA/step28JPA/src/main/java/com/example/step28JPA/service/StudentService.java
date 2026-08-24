package com.example.step28JPA.service;

import com.example.step28JPA.model.Student;
import com.example.step28JPA.repository.DepartmentRepository;
import com.example.step28JPA.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private DepartmentRepository departmentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void create(Student student, Long deptId) {


    }

}
