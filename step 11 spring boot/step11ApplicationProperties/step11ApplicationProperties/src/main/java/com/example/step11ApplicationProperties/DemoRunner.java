package com.example.step11ApplicationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner {

    private PaymentGateway paymentGateway;

    @Autowired
    public DemoRunner(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        paymentGateway.print();
    }
}
