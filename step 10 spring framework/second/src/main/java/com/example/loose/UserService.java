package com.example.loose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

    // loose coupling

    // field injection
//    @Autowired
    public NotificationSerive notificationSerive;

    public UserService() {

    }

    // constructor injection
    @Autowired
    public UserService(@Qualifier("emailNotificationSerice") NotificationSerive notificationSerive) {
        this.notificationSerive = notificationSerive;
    }

    public void notifyUser(String message){
       notificationSerive.send("notification " + message);
    }

    // setter injection
    public void setNotificationSerive(NotificationSerive notificationSerive) {
        this.notificationSerive = notificationSerive;
    }
}
