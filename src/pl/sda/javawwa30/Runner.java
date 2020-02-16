package pl.sda.javawwa30;

import java.time.LocalDate;

public class Runner {

    public static void main(String[] args) {
        Author author = new Author("Bogdan Goralczyk", 'm', LocalDate.of(1954, 2, 22));
        Author author2 = new Author("Ryszard Kapuscinski", 'm', LocalDate.of(1921, 1, 4));
        Author[] authors = {author, author2};
        Book book = new Book("Chiny: Wielki Renesans", authors, 70);

        System.out.println(book);
        System.out.println(book.getAuthorsNames());
    }

}
