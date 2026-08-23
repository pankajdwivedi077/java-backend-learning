package com.example.step28JPA.controller;

import com.example.step28JPA.model.Department;
import com.example.step28JPA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

  private DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService){
      this.departmentService = departmentService;
  }

  @PostMapping
  public ResponseEntity<String> createDepartment(@RequestBody Department department){
      departmentService.create(department);
      return  ResponseEntity.ok("Done");
  }

}
