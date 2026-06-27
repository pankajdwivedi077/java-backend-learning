import java.util.Optional;

public class File17 {
    public static void main(String[] args) {
        
      String name = "raj";

    // old way to handle null 
    //   if (name != null){
    //     System.out.println(name.length());
    //   }else{
    //     System.out.println("no value for name");
    //   }

    // create optional
    Optional<String> optionalString = Optional.of("java");
    System.out.println(optionalString);

    Optional<String> empty = Optional.empty();
    System.out.println(empty);

    Optional<String> mayBe = Optional.ofNullable(null);
    System.out.println(mayBe);

    // checking values
    System.out.println(optionalString.isPresent());
    System.out.println(mayBe.isPresent());

    System.out.println(optionalString.isEmpty());
    System.out.println(mayBe.isEmpty());

    // get
    System.out.println(optionalString.get()); // not a right way only use if you have confirm that optional is not empty

    // orElse()
    System.out.println(optionalString.orElse("defalut"));
    System.out.println(mayBe.orElse("defalut"));
    String item = mayBe.orElse("default");

    // orElseGet()
    String result = mayBe.orElseGet(() -> {
        System.out.println("generating defalut value");
        return "default";
    });

    System.out.println(result);

    // orElseThrow()
    String  newResult = optionalString.orElseThrow(
        () -> new RuntimeException("Not found")
    );
    System.out.println(newResult);

     

    }
}
// optionals introducted in java 8