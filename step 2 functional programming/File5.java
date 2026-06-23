import java.util.function.BiFunction;

public class File5 {

    // take two arguments return one number -> using generic 
    public static BiFunction<Integer, Integer, Integer> addFunc = (a,b) -> a+b; 

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> min = (a,b) -> a-b;
        System.out.println(min.apply(10, 3));

        System.out.println(addFunc.apply(4, 6));

    }
}
// Bi Function