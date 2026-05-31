class Library {

    int availabBooks = 3;

    public void borrowBook(int booksRequested){

        try {

        int [] booksId = {101,102,103};
        System.out.println("Book requested : " + booksId[booksRequested]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of bound");
        }catch (NullPointerException e){

        }finally{

        }
       
    }
}

public class File8 {
    public static void main(String [] args){
      
        Library lib = new Library();
        lib.borrowBook(2);

    }
}
// library management example