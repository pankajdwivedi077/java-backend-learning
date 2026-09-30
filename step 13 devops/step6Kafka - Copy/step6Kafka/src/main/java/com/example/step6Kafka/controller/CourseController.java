package com.example.step6Kafka.controller;

import com.example.step6Kafka.model.Course;
import com.example.step6Kafka.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService= courseService;
    }

    @GetMapping()
    public ResponseEntity<String> getCourse(){
       String res = courseService.getMessage();
      return ResponseEntity.ok(res);
    }

}
