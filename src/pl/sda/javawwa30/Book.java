package pl.sda.javawwa30;

public class Book {

    final private String title;
    final private Author author;
    private double price;

    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book[" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ']';
    }
}
