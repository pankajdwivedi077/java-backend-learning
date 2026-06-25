public class Book {

    String title;
    int publicationYear;
    double price;
    String category;

    public Book(String title, int publicationYear, double price, String category){
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", publicationYear=" + publicationYear + ", price=" + price + ", category="
                + category + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   


}
