import java.util.function.Function;

public class File3 {

    public static Function<Integer, Integer> addFunction = (a) -> a + 3; // using Generics 

    public static void main(String[] args) {

        System.out.println(addFunction.apply(10));
    }
}
// Function interface -> one input and return one output
// inbuild functional interface