package com.example.step26Hinernate.repositoty;

import com.example.step26Hinernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create
    public void save(Student student){
        entityManager.persist(student);
    }

   // read
   public Student findById(Long id){
        Student s1 = entityManager.find(Student.class, id);
        Student s2 = entityManager.find(Student.class, id);
        entityManager.detach(s1);// remove of persistence context 
        return s2;
   }

   // delete
   public void remove(Student student){
        entityManager.remove(student);
   }

}
