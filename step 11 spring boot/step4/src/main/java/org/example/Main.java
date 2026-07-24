package org.example;
import org.example.payment.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        PaymentService paymentService = context.getBean(PaymentService.class);
//        paymentService.pay();

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

        User user = context.getBean(User.class);
        System.out.println(user.getName());

      // reflectionApis

      // class
      Class<Student> c1 = Student.class; // store student class meta data -> class name, fields, constrcutors, methods, Annotations


    }
}

class Student{

    private String name;
    private int age;

    public Student(){

    }

    public void studentDetails(){
        System.out.println("student age "+ this.age + " student name "+ this.name);
    }


}
