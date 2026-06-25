import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class File16 {
    public static void main(String[] args) {
        
         List<Book> books = Arrays.asList(
             new Book("Jujutsu Kaisen Vol 1", 2018, 450.0, "Shonen"),
             new Book("That Time I Got Reincarted As A Slime Vol 1", 2014, 650.0, "Isekai"),
              new Book("Re:Zero Starting Life in Another World Vol 1", 2014, 550.0, "Isekai"),
          new Book("Cyberpunk: Edgerunners Novel", 2022, 599.0, "Sci-Fi"),
          new Book("Horimiya Vol 1", 2015, 399.0, "Romance"),
          new Book("Berserk Deluxe Edition 1", 2019, 1200.0, "Dark Fantasy"),
          new Book("Death Note Black Edition", 2010, 850.0, "Mystery")
        );
      
        // total cost of all books
        System.out.println("total cost of all books");
        double cost = books.stream()
          .mapToDouble(book -> book.price)
          .reduce(0, (acc, sum) -> acc + sum);
          System.out.println("cost " + cost);

        // collecting books into a list of titles
          System.out.println("collecting books into a list of titles");
          List<String> bookTitles = books.stream().map(b -> b.title).collect(Collectors.toList()); // mutable
          List<String> bookTitles2 = books.stream().map(b -> b.title).toList(); // immutable 
          System.out.println(bookTitles + " booktitles");
          System.out.println(bookTitles2 + " booktitles");

        // grouping books by category
        System.out.println("grouping books by category");
        Map<String, List<Book>> groupingByCategory = books.stream().collect(Collectors.groupingBy(bookStringFn));
        groupingByCategory.forEach((category, bookList) -> {
            bookList.forEach(b -> System.out.println(b.getTitle()));
        });

    }

    static Function<Book, String> bookStringFn = new Function<Book,String>() {
        @Override
        public String apply(Book book){
            return book.getCategory();
        }
    };
}
