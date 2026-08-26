package com.example.step30SpringDataJpa.service;

import com.example.step30SpringDataJpa.entity.Student;
import com.example.step30SpringDataJpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student st) {
        studentRepository.save(st);
    }

    public Student fetchStudentById(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        return s.get();
    }

    public void updateStudent(Student studentReq, Long id){

        Optional<Student> studentRes = studentRepository.findById(id);

        Student student = studentRes.get();

        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
    }

    public List<Student> fetchAll(String name){

        Sort sort = Sort.by("age");

        List<Student> studentList = studentRepository.findAll(sort);

        Pageable pageable = PageRequest.of(0,10);

        Page<Student> studentList2 = studentRepository.findAll(pageable);

        for(Student s: studentList2.getContent()){
            System.out.println(s);

        }
        for(Student s: studentList){
            System.out.println(s);
        }
        return  studentList;
    }

}
