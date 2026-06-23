import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class File7 {
    public static void main(String[] args) {

        Predicate<Integer> isEven = (n) -> n%2 == 0;
        System.out.println(isEven.test(10));

        BiPredicate<Integer, Integer> isSumEven = (a,b) -> (a+b) % 2 == 0;
        System.out.println(isSumEven.test(10, 2));
    }
}
// predicator