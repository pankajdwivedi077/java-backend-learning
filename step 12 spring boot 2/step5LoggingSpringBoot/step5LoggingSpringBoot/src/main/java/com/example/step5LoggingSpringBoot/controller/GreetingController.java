package com.example.step5LoggingSpringBoot.controller;

import com.example.step5LoggingSpringBoot.service.GreetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetingController {

  private GreetService greetService;

  private static final Logger log = LogManager.getLogger(GreetingController.class);

  private static final org.slf4j.Logger log2 =
          LoggerFactory.getLogger(GreetingController.class);

  @Autowired
  public GreetingController(GreetService greetService){
      this.greetService = greetService;
  }

  @GetMapping()
  public ResponseEntity<String> generateGreeting(){
      log2.info("Control in api");
      String body = greetService.generateWishes();
      log2.info("Service logic is been called");
      log2.debug("debug used");
      return new ResponseEntity<String>(body, HttpStatus.OK);
  }

}
