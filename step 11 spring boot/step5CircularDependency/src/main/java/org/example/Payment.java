package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Payment {

  // @Autowired
 //  private OrderService orderService;

//   @Autowired
//   public Payment(OrderService orderService){
//       this.orderService = orderService;
//   }


    public void pay() {

        System.out.println("Payment done");

        // not its responsibility
       // orderService.getOrderDetails();

    }
}
