class BookUnavailableException extends Exception {
    public BookUnavailableException(String message){
       super(message);
    }
}

class Li {

    int availabBooks = 3;

    public void borrowBook(int booksRequestedCount)throws Exception {

        if (booksRequestedCount > availabBooks)
            throw new BookUnavailableException("not enough");
    }
}

public class File10 {

    public static void main(String[] args) {
        
      Li l = new Li();
      try{
         l.borrowBook(4);
      }catch (Exception e){
           e.printStackTrace();
      }

    }
}
// custom exception