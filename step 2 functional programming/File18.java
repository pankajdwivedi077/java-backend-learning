import java.util.Optional;

public class File18 {
    public static void main(String[] args) {
        
      Optional<String> name = Optional.of("java");

      // ifPresent()
      name.ifPresent((a) -> System.out.println(a));

      // map()
      Optional<String> upperCase = name.map((value) -> value.toUpperCase());
      System.out.println(upperCase);

      // filter()
      Optional<String> temp = name.filter(n -> n.startsWith("F"));
      temp.ifPresent(n -> System.out.println(temp));

     // combinded operations
     name.filter(n -> n.startsWith("j")).map(st -> st.toUpperCase()).ifPresent(v -> System.out.println(v + " h"));

    }
}
// functional operations