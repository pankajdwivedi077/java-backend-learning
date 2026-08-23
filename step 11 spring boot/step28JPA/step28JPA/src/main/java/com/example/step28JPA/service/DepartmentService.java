package com.example.step28JPA.service;

import com.example.step28JPA.model.Department;
import com.example.step28JPA.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

   private DepartmentRepository departmentRepository;

   @Autowired
  public DepartmentService(DepartmentRepository departmentRepository){
      this.departmentRepository = departmentRepository;
  }

    @Transactional
    public void create(Department department) {
       departmentRepository.save(department);
    }
}
