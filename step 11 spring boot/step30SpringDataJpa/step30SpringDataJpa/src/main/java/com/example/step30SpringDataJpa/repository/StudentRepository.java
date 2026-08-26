package com.example.step30SpringDataJpa.repository;

import com.example.step30SpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
            select * from student
            where email = ?1
            """, nativeQuery = true)
    Optional<Student> findByEmail(String email);

    Optional<Student> findByEmailLike(String pattern);

}
