package com.example.step28JPA.service;

import com.example.step28JPA.model.Department;
import com.example.step28JPA.model.Student;
import com.example.step28JPA.repository.DepartmentRepository;
import com.example.step28JPA.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Student s1 = new Student();

        s1.setName("aditya");

        s1.setDepartment(department);

        department.getStudentList().addAll(List.of(s1));

       departmentRepository.save(department);
//       studentRepository.save(s1);
    }

}
