package org.example;

public class OrderService {

 //   private PaymentService paymentService;
    private PaymetServiceExmp paymentService;

    public OrderService(){

    }

    public OrderService(PaymetServiceExmp paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    public  void placeOrder(){
        paymentService.pay();
        System.out.println("Order placed");
    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
