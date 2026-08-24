package com.example.step28JPA.service;

import com.example.step28JPA.model.Department;
import com.example.step28JPA.repository.DepartmentRepository;
import com.example.step28JPA.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

   private DepartmentRepository departmentRepository;

   private StudentRepository studentRepository;

   @Autowired
  public DepartmentService(DepartmentRepository departmentRepository,
                           StudentRepository studentRepository){
      this.departmentRepository = departmentRepository;
      this.studentRepository = studentRepository;
  }

    @Transactional
    public void create(Department department) {

    }

}
