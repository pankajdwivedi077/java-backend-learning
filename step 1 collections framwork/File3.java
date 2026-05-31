import java.util.HashMap;
import java.util.Map;

public class File3 {
    public static void main(String[] args) {
        
       Map<Integer, String> userMap = new HashMap<>();

       userMap.put(1, "raj");
       userMap.put(2, "raju");
       userMap.put(3, "bete");

       System.out.println(userMap.get(1));

       for(Map.Entry<Integer, String> entry : userMap.entrySet()){
        System.out.println(entry.getKey() + " " + entry.getValue());
       }

    }
}
// Map || key value pair