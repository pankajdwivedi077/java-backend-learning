package loose;

public class EmailNotificationSerice implements NotificationSerive{
    @Override
    public void send(String message) {
        System.out.println("Emial "+ message);
    }
}
