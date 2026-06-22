@FunctionalInterface
interface Operation {
    int add(int a, int b);
}

public class File2 {
    public static void main(String[] args){

      Operation op = (int a, int b) -> {
          return a+b;
      };

     System.out.println(op.add(1, 2));

     

    }
}
