import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File15 {
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        // reduce
        Stream<Integer> intStream = numbers.stream();
        int sum = intStream.reduce(0, (acc, num) -> acc + num);
        System.out.println(sum);

        // collect
        List<Integer> evenNumber = numbers.stream()
                     .filter(n -> n % 2 == 0)
                     .collect(Collectors.toList());
        System.out.println(evenNumber + " evenNumber");

       Set<Integer> evenSet = numbers.stream()
                     .filter(n -> n % 2 == 0)
                     .collect(Collectors.toSet());
        System.out.println(evenSet + " set");

        // find & match
       System.out.println(numbers.stream().findFirst().get()); 

       boolean has2 = numbers.stream().anyMatch(n -> n == 2);

       // iteration
       numbers.stream().forEach(n -> System.out.println(n));


    }
}
// terminal operations 

// reduce
// collect
// find & match
// iteration