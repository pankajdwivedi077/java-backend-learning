import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class File6 {
    public static void main(String[] args) {

        Consumer<String> consumer1 = (str) -> System.out.println(str);

        // Consumer<String> consumer2 = System.out::println;

        consumer1.accept("Hello");

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> multiByTwo = (n) -> System.out.println(n*2);
        num.forEach(multiByTwo);

        BiConsumer<Integer, Integer> addConsumer = (a,b) -> System.out.println("Addition " + a+b);
        addConsumer.accept(10, 30);

    }
}
// Consumer interface
// take one input return no output

// BiConsumer
// take two input return no output