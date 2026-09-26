package com.example.step5MicroservicesQuestionS.service;

import com.example.step5MicroservicesQuestionS.dao.QuestionDao;
import com.example.step5MicroservicesQuestionS.model.Question;
import com.example.step5MicroservicesQuestionS.model.QuestionWrapper;
import com.example.step5MicroservicesQuestionS.model.Response;
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
        List<Question> questions = new ArrayList<>();
        for(Integer id: questionIds){
            questions.add(questionDao.findById(id).get());
        }
        for(Question q: questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setQuestionTitle(q.getQuestionTitle());
            wrapper.setOption1(q.getOption1());
            wrapper.setOption2(q.getOption2());
            wrapper.setOption3(q.getOption3());
            wrapper.setOption4(q.getOption4());
            questionWrappers.add(wrapper);
        }
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right = 0;
        for(Response response1: responses){
            Question question = questionDao.findById(response1.getId()).get();
            if(response1.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
