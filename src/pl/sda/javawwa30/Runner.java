package pl.sda.javawwa30;

import java.time.LocalDate;

public class Runner {

    public static void main(String[] args) {
        Author author = new Author("Bogdan Goralczyk", 'm', LocalDate.of(1954, 2, 22));
        Book book = new Book("Chiny: Wielki Renesans", author, 70);

        System.out.println(book);
    }

}
