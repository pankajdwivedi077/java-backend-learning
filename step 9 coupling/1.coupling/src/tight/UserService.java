package tight;

public class UserService {

    // tight coupling
    NotificationService notificationService = new NotificationService();

    public void notifyUser(String message){
        notificationService.send("Notification hello " + message);
    }

}
