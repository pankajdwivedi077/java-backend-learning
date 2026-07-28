package com.example.step10SpringCore;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay() {
        System.out.println("payment done");
    }
}
