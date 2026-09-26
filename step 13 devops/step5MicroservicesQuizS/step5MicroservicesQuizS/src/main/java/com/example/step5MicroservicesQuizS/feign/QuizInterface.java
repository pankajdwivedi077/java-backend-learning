package com.example.step5MicroservicesQuizS.feign;

import com.example.step5MicroservicesQuizS.model.QuestionWrapper;
import com.example.step5MicroservicesQuizS.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("STEP5MICROSERVICESQUESTIONS")
public interface QuizInterface {

    // generate
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz
    (@RequestParam String catgeoryName, @RequestParam Integer numberQuenstions);
    // getQuestions (questionId)
    @PostMapping("/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId
    (@RequestBody List<Integer> questionIds);
    // getScore
    @PostMapping("/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);

}
