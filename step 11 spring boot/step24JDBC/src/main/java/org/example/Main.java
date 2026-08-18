package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createUser();
//          studentRepository.updateUser();
//        studentRepository.deleteUser();
//          studentRepository.getUserById();

//        studentRepository.createUser2(new Student("ace", "ace@gmail.com", 23));

        studentRepository.createUser3(new Student("bete",
                "bete@gmail.com", 23));

    }
}