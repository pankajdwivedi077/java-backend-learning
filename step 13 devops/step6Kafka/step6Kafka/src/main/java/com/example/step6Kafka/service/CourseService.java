package com.example.step6Kafka.service;

import com.example.step6Kafka.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private KafkaTemplate<String, Course> kafkaTemplate;

    @Autowired
    public CourseService(KafkaTemplate<String, Course> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(Course course){
        kafkaTemplate.send("test", "course", course);
        return "course sent to kafka";
    }

}
