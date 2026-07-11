import loose.EmailNotificationSerice;
import tight.UserService;

public class AppMain {

    public static void main(String[] args) {

        // tight coupling
        UserService userService = new UserService();
        userService.notifyUser("Order placed");

        // loose coupling

        EmailNotificationSerice email = new EmailNotificationSerice();
//        loose.UserService userService1 = new loose.UserService(email);
//        userService1.notifyUser("hello");

        // setter injection
        loose.UserService userService1 = new loose.UserService();
        userService1.setNotificationSerive(email);
        userService1.notifyUser("hello");

        // field injection
        loose.UserService userService2 = new loose.UserService();
        userService2.notificationSerive = email;
        userService2.notifyUser("hello");
    }

}
