import java.util.function.Function;

public class File3 {

                     // using Generics 
    public static Function<Integer, Integer> addFunction = (a) -> a + 3; 
    public static Function<Integer, Integer> subtractFunction = (a) -> a - 3; 

    // chaining
    public static Function<Integer, Integer> combineFunction = 
      addFunction.andThen(subtractFunction);

    public static void main(String[] args) {

        System.out.println(addFunction.apply(10));
        System.out.println(subtractFunction.apply(10));
        System.out.println(combineFunction.apply(10));
    }
}
// Function interface -> one input and return one output
// inbuild functional interface