package learning;

public class JunitCourse implements Course {
	
   @Override
   public boolean coursePurchase() {
	   System.out.println("Junit course purchased");
	   return true;
   }
   
}
