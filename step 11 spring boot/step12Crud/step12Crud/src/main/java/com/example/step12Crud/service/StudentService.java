package com.example.step12Crud.service;

import com.example.step12Crud.entity.Student;
import com.example.step12Crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Student createStudent(Student studentReq) {
        // business logic

        // store to db
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {


       // Optional<Student> res = studentRepository.findById(id);
        Optional<Student> res = studentRepository.findByIdAndDeletedIsFalse(id);
        if(res.isPresent()){
            return res.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {

       // List<Student> studentList = studentRepository.findAll();
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student update(Long id, Student st) {

        // Optional<Student> res = studentRepository.findById(id);
        Optional<Student> res = studentRepository.findByIdAndDeletedIsFalse(id);
        if(res.isEmpty()){
            return null;
        }
        Student studentToSave = res.get();
        studentToSave.setName(st.getName());
        studentToSave.setRoleNo(st.getRoleNo());
        studentToSave.setSubject(st.getSubject());
        studentToSave.setEmail(st.getEmail());
        studentToSave.setAge(st.getAge());

        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }

    public Boolean delete(Long id) {

        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }


    public Boolean deleteStudentSoftly(Long id) {

       Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
       if(existingStudent.isEmpty()){
           return false;
       }
       Student studentToSave = existingStudent.get();
       studentToSave.setDeleted(true);
       studentRepository.save(studentToSave);
       return true;
    }
}
