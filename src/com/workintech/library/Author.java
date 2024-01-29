package com.workintech.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person {

    private List<Books> books;


    public Author(String name) {
        super(name);
        this.books= new ArrayList<>();
    }

    public void new_book(Books book) {
        this.books.add(book);
    }

    public void removeBook(Books book) {
        this.books.remove(book);
    }

    public List<Books> show_book() {
        return this.books;
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
