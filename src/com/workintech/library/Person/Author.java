package com.workintech.library.Person;

import com.workintech.library.Book.Books;
import com.workintech.library.Book.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person {

    private List<Books> books;


    public Author(String name) {
        super(name);
        this.books= new ArrayList<>();
    }

    public void new_book(int book_id,Type type, String name, double price, int edition) {
        Books book = new Books( book_id,this.getName(), type, name, price, edition);
        books.add(book);
    }

    public void removeBook(Books book) {
        this.books.remove(book);
    }

    public void showBooks() {
        for (Books book : books) {
            System.out.println(book.display());
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("The author name is: " + super.getName());
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
