package com.example.step5MicroservicesQuizS.dao;

import com.example.step5MicroservicesQuizS.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {



}
