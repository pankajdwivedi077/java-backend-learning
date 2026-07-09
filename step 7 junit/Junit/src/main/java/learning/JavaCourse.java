package learning;

public class JavaCourse implements Course {
	
   @Override
   public boolean coursePurchase() {
	   System.out.println("Java course purchased");
	   return true;
   }
   
}
