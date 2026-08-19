package com.example.step25SpringJdbc.service;

import com.example.step25SpringJdbc.model.Student;
import com.example.step25SpringJdbc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student, student.getId());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}
