import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File11 {
    public static void main(String[] args) {
        
       List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
       List<Integer> evenNum1 = new ArrayList<>();

    // List: Even number from numbers list

    //   for(int i=0; i<numbers.size(); i++){
    //     if(numbers.get(i) % 2 == 0){
    //       evenNum1.add(numbers.get(i));
    //     }
    //   }
    //    System.out.println(evenNum1);


       for(int num: numbers){
        if (num%2 == 0){
          evenNum1.add(num);
        }
       }
      System.out.println(evenNum1);

      // using streams 

      Stream<Integer> intStream = numbers.stream();
      Stream<Integer> evenStream = intStream.filter(p);
      List<Integer> evenNum2 = evenStream.toList();
      System.out.println("stream  "+evenNum2);

      // 3rd way

      List<Integer> evenList = numbers.stream()
        //    .filter(p2)
            .filter((num) -> num % 2 == 0)
           .collect(Collectors.toList());
      System.out.println(evenList + " 3rd");
 
    }

    static Predicate<Integer> p = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer){
           int remainder = integer % 2;
           if(remainder == 0) return true;
           return false;
        }
    };

    static Predicate<Integer> p2 = (integer) -> integer % 2 == 0;
    
}
// stream pipeline