import java.util.function.BiFunction;

public class File9 {
    public static void main(String[] args) {

        BiFunction<String, Double, String> formatter = (title, price) -> title + " costs $ " + price;
        System.out.println(formatter.apply("Java", 1000.0));

        
    }
}
// example