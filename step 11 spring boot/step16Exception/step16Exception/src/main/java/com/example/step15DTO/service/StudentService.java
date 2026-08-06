package com.example.step15DTO.service;

import com.example.step15DTO.dto.StudentRequestDTO;
import com.example.step15DTO.dto.StudentResponseDTO;
import com.example.step15DTO.dto.StudentUpdateRequestDTO;
import com.example.step15DTO.dto.StudentUpdateResponseDTO;
import com.example.step15DTO.entity.Student2;
import com.example.step15DTO.exception.DuplicateResourceException;
import com.example.step15DTO.exception.ResourceNotFoundException;
import com.example.step15DTO.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

  StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository){
      this.studentRepository = studentRepository;
  }

  public StudentResponseDTO createStudent(StudentRequestDTO studentReq){
      Student2 student = mapToEntity(studentReq);
      if(emailExists(student)){
          throw new DuplicateResourceException("Email id already exists");

      }
      Student2 studentResp =  studentRepository.save(student);
      return mapToDTO(studentResp);
  }

  public StudentUpdateResponseDTO updateStudent(Long id,StudentUpdateRequestDTO student) {
        Optional<Student2> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student2 studentToSave = existingStudent.get();

        studentToSave.setName(student.getName());

        Student2 studentResp = studentRepository.save(studentToSave);
        return  mapToUpdateDTO(studentResp);
    }

    public StudentResponseDTO getStudent(Long id){
      Student2 s = studentRepository
              .findById(id)
              .orElseThrow(()-> new ResourceNotFoundException(id + " Not found"));
      return mapToDTO(s);
    }

  private Student2 mapToEntity(StudentRequestDTO requestDTO){
      Student2 student = new Student2();
      student.setName(requestDTO.getName());
      student.setEmail(requestDTO.getEmail());
      student.setCreatedAt(LocalDateTime.now());
      student.setUpdatedAt(LocalDateTime.now());
      return student;
  }

  private StudentResponseDTO mapToDTO(Student2 student){
      StudentResponseDTO resp = new StudentResponseDTO();
      resp.setId(student.getId());
      resp.setName(student.getName());
      resp.setEmail(student.getEmail());
      resp.setMessage("Student saved");
      return resp;
  }

  private StudentUpdateResponseDTO mapToUpdateDTO(Student2 st){
      StudentUpdateResponseDTO resp = new StudentUpdateResponseDTO();
      resp.setEmail(st.getEmail());
      resp.setId(st.getId());
      resp.setName(st.getName());
      resp.setMessage("updated");
      return resp;
  }

  private boolean emailExists(Student2 st){
      return studentRepository.existsByEmail(st.getEmail());
  }

}
