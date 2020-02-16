package pl.sda.javawwa30;

import java.util.Arrays;

public class Book {

    final private String title;
    final private Author[] authors;
    private double price;

    public Book(String title, Author[] authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book[" +
                "title='" + title + '\'' +
                ", author=" + Arrays.toString(authors) +
                ", price=" + price +
                ']';
    }

    public String getAuthorsNames() {
        StringBuilder strBld = new StringBuilder();
        for(Author a : authors) {
            strBld.append(a.getName() + ", ");
        }
        return strBld.toString();
    }
}
