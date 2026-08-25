package com.example.step30SpringDataJpa.repository;

import com.example.step30SpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
