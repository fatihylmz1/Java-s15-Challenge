package com.workintech.library;

public abstract class Library {
    private Books books;

    private Reader readers;

    public Books show_books() {
        return books;
    }

    public Reader getReaders() {
        return readers;
    }

    public void new_book(int book_id , Author author, Type type , String name, double price, String edition){
        Books book = new Books(book_id,author,type,name,price,edition){};
    }
}
