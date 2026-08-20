package com.example.step26Hinernate.service;

import com.example.step26Hinernate.model.Student;
import com.example.step26Hinernate.repositoty.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {

        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student student, Long id) {

        Student student1 = studentRepository.findById(id);

        if(student1 == null){
            throw  new RuntimeException("Student not found");
        }

        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());

    }

    @Transactional
    public void deleteStudent(Long id) {
      Student student = studentRepository.findById(id);

      if(student == null){
          throw  new RuntimeException("Student not found");
      }
      studentRepository.remove(student);
    }
}
