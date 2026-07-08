package junit;

public class Main {
   public static void main(String[] args) {
	   
	   Calc cal = new Calc();    // unit testing without testing framework
	   
	   int result = cal.divide(10, 5);
	   
	   if(result==2)
		   System.out.println("test case passed");
	   else
		   System.out.println("test case failed");	   
       
   }
}
