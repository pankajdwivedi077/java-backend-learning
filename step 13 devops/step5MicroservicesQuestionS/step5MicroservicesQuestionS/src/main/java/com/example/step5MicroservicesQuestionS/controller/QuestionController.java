package com.example.step5MicroservicesQuestionS.controller;

import com.example.step5MicroservicesQuestionS.model.Question;
import com.example.step5MicroservicesQuestionS.model.QuestionWrapper;
import com.example.step5MicroservicesQuestionS.model.Response;
import com.example.step5MicroservicesQuestionS.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(
            @PathVariable String category){
        return questionService.getQuenstionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuention(@RequestBody Question quenstion){
        return  questionService.addQuestion(quenstion);
    }

    // generate
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz
    (@RequestParam String catgeoryName, @RequestParam Integer numberQuenstions){
        return questionService.getQuestionsForQuiz(catgeoryName, numberQuenstions);
    }
    // getQuestions (questionId)
    @PostMapping("/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId
    (@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }
    // getScore
    @PostMapping("/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
        return questionService.getScore(response);
    }
}
