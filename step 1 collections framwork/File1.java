import java.util.ArrayList;
import java.util.List;

public class File1 {
    public static void main(String[] args){

        List<String> users = new ArrayList<>();

        users.add("Alice");
        users.add("Bob");
        users.add("Ace");

        System.out.println("printing list");

        for(String user: users){
            System.out.println(user);
        }

        System.out.println(users.get(2));
        

    }
} // List || ArrayList