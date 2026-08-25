package com.example.step28JPA.repository;

import com.example.step28JPA.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student s1) {
        entityManager.persist(s1);
    }

    // solve n + 1 problem which arise because of lazy loading
    @EntityGraph(attributePaths = "department")
    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }
}
