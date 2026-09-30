package com.example.step6Kafka.service;

import com.example.step6Kafka.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private String message;

    public CourseService(){

    }

    @KafkaListener(topics = "test", groupId = "test-group")
    public void consume(Course course){
        message = course + " Got the data";
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
