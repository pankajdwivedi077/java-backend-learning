package com.example.step5MicroservicesQuizS.controller;

import com.example.step5MicroservicesQuizS.dao.QuizDto;
import com.example.step5MicroservicesQuizS.model.QuestionWrapper;
import com.example.step5MicroservicesQuizS.model.Response;
import com.example.step5MicroservicesQuizS.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),
                quizDto.getNumQuestions(), quizDto.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable
                                                                      Integer id){
        return quizService.getQuizQ(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
