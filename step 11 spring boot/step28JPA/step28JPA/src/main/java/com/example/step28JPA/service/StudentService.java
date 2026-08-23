package com.example.step28JPA.service;

import com.example.step28JPA.model.Department;
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

        Department department = departmentRepository.getDepartmentById(deptId);

        student.setDepartment(department);

        studentRepository.save(student);
    }

    @Transactional
    public void create(Student student, String departmentName) {

        Department department = new Department();
        department.setName(departmentName);

        departmentRepository.save(department);

        student.setDepartment(department);

        studentRepository.save(student);
    }
}
