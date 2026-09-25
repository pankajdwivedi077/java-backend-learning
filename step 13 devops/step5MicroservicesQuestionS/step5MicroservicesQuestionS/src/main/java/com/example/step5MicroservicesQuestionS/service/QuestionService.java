package com.example.step5MicroservicesQuestionS.service;

import com.example.step5MicroservicesQuestionS.dao.QuestionDao;
import com.example.step5MicroservicesQuestionS.model.Question;
import com.example.step5MicroservicesQuestionS.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
         try {
             return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
         }catch (Exception e){
             e.printStackTrace();
         }
         return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuenstionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question quenstion) {
        questionDao.save(quenstion);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (String catgeoryName, Integer numberQuenstions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory
                (catgeoryName, numberQuenstions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId
            (List<Integer> questionIds) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }
}
