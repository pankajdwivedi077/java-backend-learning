package com.example.step6Kafka.controller;

import com.example.step6Kafka.model.Course;
import com.example.step6Kafka.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService= courseService;
    }

    @PostMapping()
    public ResponseEntity<String> addCourse(@RequestBody Course course){
       String response = courseService.sendMessage(course);
        return ResponseEntity.ok(response);
    }

}
