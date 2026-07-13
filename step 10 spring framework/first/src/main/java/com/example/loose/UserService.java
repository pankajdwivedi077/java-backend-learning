package com.example.loose;

public class UserService {

    // loose coupling

    public NotificationSerive notificationSerive;

    public UserService() {

    }

    // constructor injection
    public UserService(NotificationSerive notificationSerive) {
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
