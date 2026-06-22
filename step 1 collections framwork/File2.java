import java.util.HashSet;
import java.util.Set;

public class File2 {

    public static void main(String[] args){

        Set<String> roles = new HashSet<>();

        roles.add("Admin");
        roles.add("User");
        roles.add("Manager");
        roles.add("Manager");

        for(String role: roles){
            System.out.println(role);
        }

        System.out.println(roles);

    }
} // set || duplicate not allowed
