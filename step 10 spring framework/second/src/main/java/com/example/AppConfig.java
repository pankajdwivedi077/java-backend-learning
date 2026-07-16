package com.example;

import com.example.loose.NotificationSerive;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

 @Bean(initMethod = "init", destroyMethod = "cleanUp")
    public LifeCycleBean lifeCycleBean(@Qualifier("emailNotificationSerice") NotificationSerive notificationSerive){
     return new LifeCycleBean(notificationSerive);
 }

}
