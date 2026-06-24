import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class File12 {
    public static void main(String[] args) {
        
       List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
       Stream<Integer> integerStream = numbers.stream();
       integerStream.forEach(System.out::println);
    //    integerStream.forEach((item) -> System.out.println(item));

     int [] numArray = {1,2,3,4};
     IntStream arrayStream = Arrays.stream(numArray);
     arrayStream.forEach(System.out::println);

     Stream<String> stringStream = Stream.of("a", "b");
    //  Stream<Integer> intStream = Stream.iterate(0, n -> n + 2);

    try {
        Stream<String> fileStream = Files.lines(Path.of("path"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Stream<String> emptyStream = Stream.empty();
 
    }
}
// stream with different sources

// collections -> collection.stream()
// from array -> Arrays.stream()
// from specific values -> Stream.of("a"< "b")
// from functions -> Stream.iterate(0, n-> n+2)
// from files -> Files.lines(path)
// empty stream -> Stream.empty()