package com.workintech.library;


import java.util.List;

public class Reader extends Person{

    private List<Books> books;
    public Reader(String name) {
        super(name);
    }

    public void purchase_book(Books book) {
        this.books.add(book);
    }
    public void return_book(Books book){this.books.remove(book);}

    @Override
    public void whoyouare() {
        System.out.println("The reader name is: " + super.getName());
    }
}
