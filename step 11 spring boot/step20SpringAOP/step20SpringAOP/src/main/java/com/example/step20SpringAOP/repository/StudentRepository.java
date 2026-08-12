package com.example.step20SpringAOP.repository;

import com.example.step20SpringAOP.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student){
        System.out.println("saved");
    }

}
