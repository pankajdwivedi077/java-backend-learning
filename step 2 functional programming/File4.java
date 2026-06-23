import java.util.Arrays;
import java.util.List;

public class File4 {
    public static void main(String[] args) {
        
        // ::

        List<String> names = Arrays.asList("Alice", "Bob", "raj");

        for(String name: names){
            System.out.println(name);
        }

        names.forEach((name) -> {
            System.out.println(name);
        });

        names.forEach(System.out::println);

    }
}
// method references