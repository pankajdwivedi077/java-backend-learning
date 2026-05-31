public class File7 {
    public static void main(String[] args) {
        
       int [] arr = {1,2,3};
       try{
         System.out.println(arr);
       }catch (ArrayIndexOutOfBoundsException e){
          System.out.println("array index out of bound");
       }catch(ArithmeticException e){

       }finally{
        System.out.println("final");
       }
       System.out.println("yes");

    }
}
// try with multiple catch & finally block