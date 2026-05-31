import java.io.FileNotFoundException;
import java.io.FileReader;

public class File6 {
   public static void main(String[] args) {
    
      try{
        int ans = 10/0;
      }catch (ArithmeticException e){
          System.out.println("can't divide by 0" );
      }
      System.out.println("yo");

     // checked exceptions

     try {
        FileReader fileReader = new FileReader("abc.txt");
    } catch (FileNotFoundException e) {
        
        e.printStackTrace();
    }


   }   
}
// Exceptions