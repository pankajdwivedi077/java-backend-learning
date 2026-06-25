import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class File14 {
    public static void main(String[] args) {
        
          List<Book> books = Arrays.asList(
          new Book("Re:Zero Starting Life in Another World Vol 1", 2014, 550.0, "Isekai"),
          new Book("Jujutsu Kaisen Vol 1", 2018, 450.0, "Shonen"),
          new Book("Cyberpunk: Edgerunners Novel", 2022, 599.0, "Sci-Fi"),
          new Book("Horimiya Vol 1", 2015, 399.0, "Romance"),
          new Book("Berserk Deluxe Edition 1", 2019, 1200.0, "Dark Fantasy"),
          new Book("Death Note Black Edition", 2010, 850.0, "Mystery")
        );
       
        //  Identify all books that are priced over 800
        System.out.println(" Identify all books that are priced over 800");
        books.stream().filter(book -> book.price > 800).forEach(b -> System.out.println(b));

        // books before 2018
        System.out.println("books published before 2018");
        books.stream().filter(book -> book.publicationYear < 2018).forEach(b -> System.out.println(b));

        // Add suffix "coming soon" to all the current title
        System.out.println("Add suffix \"coming soon\" to all the current title");
        books.stream().map(book -> book.title + " coming soon").forEach(System.out::println);

        // sort by price
        System.out.println("sort by price");
        books.stream().sorted(Comparator.comparingDouble(book -> book.price)).forEach(System.out::println);

        // a rare book
        System.out.println("book title is more than 20 characters.");
        books.stream().filter(b -> b.title.length() > 20).forEach(System.out::println);

    }
}
// 