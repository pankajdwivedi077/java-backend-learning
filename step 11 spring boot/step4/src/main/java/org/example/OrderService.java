package org.example;

import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    // field DI

  //  @Autowired
    private final PaymentService paymentService;


    @Autowired
    public OrderService(@Qualifier("cp") PaymentService paymentService){
        this.paymentService = paymentService;
    }

//    public OrderService(){
//
//    }

    public void placeOrder(){
        System.out.println("Order placed");
        paymentService.pay();
    }

    // setter DI

//    @Autowired
//    public void setPayementSerive(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }


}
