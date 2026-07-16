package com.example;

import com.example.loose.NotificationSerive;
import org.springframework.stereotype.Component;


public class LifeCycleBean {

    private NotificationSerive notificationSerive;

    public LifeCycleBean(NotificationSerive notificationSerive) {
        System.out.println("Constructor called Dependeny injection");
        this.notificationSerive = notificationSerive;
    }

    public void init(){
        System.out.println("init called bean initialized");
        notificationSerive.send("Hello from init");
    }

    public void performTask(){
        System.out.println("Ready for use");
    }

    public void cleanUp(){
        System.out.println("clean is being called");
    }

}
