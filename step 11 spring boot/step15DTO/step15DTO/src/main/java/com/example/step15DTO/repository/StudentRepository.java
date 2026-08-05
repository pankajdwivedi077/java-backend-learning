package com.example.step15DTO.repository;

import com.example.step15DTO.entity.Student2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student2, Long> {



}
