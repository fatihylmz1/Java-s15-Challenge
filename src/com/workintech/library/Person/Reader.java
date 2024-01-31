package com.workintech.library.Person;


import com.workintech.library.Book.Books;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader extends Person {

    private Set<Books> books;
    public Reader(String name) {
        super(name);
        this.books = new HashSet<>();
    }

    public void purchase_book(Books book) {
        books.add(book);
        book.change_owner(this);
    }

    public void borrow_book(Books book){
        books.add(book);
        book.change_owner(this);
    }
    public void return_book(Books book){
        books.remove(book);
        book.change_owner(null);
    }

    public void showBooks() {
        for (Books book : books) {
            System.out.println(book.display());
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("The reader name is: " + super.getName());
    }
}
