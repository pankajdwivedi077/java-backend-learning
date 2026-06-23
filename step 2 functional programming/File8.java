import java.util.function.Supplier;

public class File8 {
    public static void main(String[] args) {

        Supplier<Double> ramdomNum = () -> Math.random();
        // Supplier<Double> ramdomNum2 =  Math::random;

        System.out.println(ramdomNum.get());
    }
}
// Supplier 