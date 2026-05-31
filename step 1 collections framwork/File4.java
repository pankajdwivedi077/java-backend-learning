import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class File4 {
    public static void main(String[] args) {
     
        List<String> users = new ArrayList<>();

        users.add("Alice");
        users.add("Bob");
        users.add("Ace");

        System.out.println("printing list");

        // for each loop

        // for(String user: users){
        //     System.out.println(user);
        // }
        
        // for loop

        // for(int i=0; i<users.size(); i++){
        //     System.out.println(users.get(i));
        // }

        // Iterator

        Iterator<String> it = users.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            // if (it.next().equals("Bob")){
            //     it.remove();
            // }
        }
        
    }
}
// Traversing collection