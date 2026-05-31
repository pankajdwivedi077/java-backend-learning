class Librarys {

    int availabBooks = 3;

    public void borrowBook(int booksRequestedCount)throws Exception {

        if (booksRequestedCount > availabBooks)
            throw new Exception("Not eough book available");
    }
}

class Libraryss {

    int availabBooks = 3;

    public void borrowBook(int booksRequestedCount) {

        try {

        if (booksRequestedCount > availabBooks)
            throw new Exception("Not eough book available");

        }catch (Exception e){
            System.out.println("Out of bound");
        }
       
    }
}


public class File9 {
    public static void main(String[] args) {
        
      Libraryss lib = new Libraryss();
      try{
       lib.borrowBook(1);
      }catch (Exception e){
        e.printStackTrace();
      }

    }
}
// throw and throws