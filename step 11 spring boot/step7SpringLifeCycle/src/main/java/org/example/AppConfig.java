package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

   public void demo(){
       System.out.println("demo");
   }

//   @Bean(initMethod = "start")
//   public CartService getCartBean(){
//       return new CartService();
//   }

       @Bean(initMethod = "start", destroyMethod = "stop")
       public CartService getCartBean(){
       return new CartService();

   }

}
