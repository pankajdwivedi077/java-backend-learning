package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Lazy
public class OrderService {

    private PaymentService paymentService;

    @Autowired
    // proxy
    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderSerice created");
    }

    public void placeOrder(){
        System.out.println("order placed");
    }

}
