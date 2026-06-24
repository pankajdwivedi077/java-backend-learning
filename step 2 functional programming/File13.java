import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class File13 {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
          new Book("Re:Zero Starting Life in Another World Vol 1", 2014, 550.0, "Isekai"),
          new Book("Jujutsu Kaisen Vol 1", 2018, 450.0, "Shonen"),
          new Book("Cyberpunk: Edgerunners Novel", 2022, 599.0, "Sci-Fi"),
          new Book("Horimiya Vol 1", 2015, 399.0, "Romance"),
          new Book("Berserk Deluxe Edition 1", 2019, 1200.0, "Dark Fantasy"),
          new Book("Death Note Black Edition", 2010, 850.0, "Mystery")
        );

        // 1. filter

        Stream<Book> stream1 = books.stream();
        Stream<Book> filterStream = stream1.filter((b) -> b.price > 1000);
        filterStream.forEach((item) -> System.out.println(item));

        // 2. Mapping

        Stream<String> stream2 = books.stream()
              .map((book) -> book.title.toUpperCase());
        System.out.println(stream2.toList());

        // 3. Sorting

        Stream<Book> sortedBooks = books.stream()
                      .sorted(Comparator.comparingInt(b -> b.publicationYear));
        sortedBooks.forEach(System.out::println);

        // 4. Distinct

        Stream<Book> uniqueBooks = books.stream().distinct();
        uniqueBooks.forEach(System.out::println);

        // 5. limit

        Stream<Book> firstThreeBooks = books.stream().limit(3);
        firstThreeBooks.forEach(book -> System.out.println(book));

       // 6. Skip

       Stream<Book> afterSkipping = books.stream().skip(2);
       afterSkipping.forEach(b -> System.out.print(b));

    }
}
// Intermediate operations