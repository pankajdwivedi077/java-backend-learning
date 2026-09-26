package com.example.step5MicroservicesQuizS.service;

import com.example.step5MicroservicesQuizS.dao.QuizDao;
import com.example.step5MicroservicesQuizS.feign.QuizInterface;
import com.example.step5MicroservicesQuizS.model.QuestionWrapper;
import com.example.step5MicroservicesQuizS.model.Quiz;
import com.example.step5MicroservicesQuizS.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private QuizDao quizDao;

    private QuizInterface quizInterface;

    @Autowired
    public QuizService(QuizDao quizDao, QuizInterface quizInterface){
        this.quizDao = quizDao;
        this.quizInterface = quizInterface;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
       List<Integer> questions =quizInterface.getQuestionForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQ(Integer id) {
      Quiz quiz = quizDao.findById(id).get();
      List<Integer> questionsIds = quiz.getQuestionIds();
      quizInterface.getQuestionsFromId(questionsIds);
      ResponseEntity<List<QuestionWrapper>> questions =
              quizInterface.getQuestionsFromId(questionsIds);

      return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

         ResponseEntity<Integer> score = quizInterface.getScore(responses);

         return score;
    }
}
