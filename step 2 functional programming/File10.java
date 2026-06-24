import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class File10 {
    public static void main(String[] args) {
        
        List<String> items = Arrays.asList("apple", "banana", "mango");

        for(String item: items){
            System.out.println(item);
        }

        items.forEach((item) -> System.out.println(item));
        System.out.println("je");

        Stream<String> st = items.stream();
        st.forEach((item) -> System.out.println(item));

        Stream<String> stream = items.stream();
        Stream<String> stre = stream.filter((item) -> item.startsWith("b"));
        stre.forEach(System.out::println);

         // use cases
         // 1. Filtering
         // 2. Mapping
         // 3. Aggregation
         // 4. Searching
         // 5. Iteration


    }
}
// Streams -> Assembly line / pipeline