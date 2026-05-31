import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class File5 {

   public static class User{

    private String name;
    private boolean active;
    private Set<String> roles;

    public User(String name, boolean active, Set<String> roles){

        this.name = name;
        this.active = active;
        this.roles = roles;
        
    }

    public boolean isActive(){
        return active;
    }

    public String getName(){
        return name;
    }

    public Set<String> getRoles(){
        return roles;
    }

   }

    public static void main(String[] args) {
        
       Set<String> user1Roles = new HashSet<>(Arrays.asList("Admin", "User")); 

       User user1 = new User("raj", true, user1Roles);

       List<User> users = new ArrayList<>();

       users.add(user1);

       users.add(new User("Bete", false, new HashSet<>(Arrays.asList("User"))));
       users.add(new User("Alice", true, new HashSet<>(Arrays.asList("Manager"))));

       // remove inactive user
       Iterator<User> it = users.iterator();

       while(it.hasNext()){
         if(!it.next().isActive()){
            it.remove();
         }
       }

       // print Active users
       for(User user: users){
        System.out.println(user.getName());
       }

       // count users per role
       Map<String, Integer> roleCount = new HashMap<>();
       for(User user: users){
        for(String role: user.getRoles()){
            roleCount.put(role, roleCount.getOrDefault(role, 0) + 1);
        }
       }

        System.out.println("printiung");
        for(Map.Entry<String, Integer> entry : roleCount.entrySet()){
           System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
// practice