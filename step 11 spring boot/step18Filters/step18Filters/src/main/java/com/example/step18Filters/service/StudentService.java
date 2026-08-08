package com.example.step18Filters.service;

import com.example.step18Filters.dto.StudentDTO;
import com.example.step18Filters.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDTO createStudent(StudentDTO st){
//        System.out.println("student created");
//        System.out.println(st.getName());
//        System.out.println(st.getEmail());

        StudentResponseDTO studnet = new StudentResponseDTO();
        studnet.setName(st.getName());
        studnet.setMessage("saved");
        return  studnet;
    }

}
