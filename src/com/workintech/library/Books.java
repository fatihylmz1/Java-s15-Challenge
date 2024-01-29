package com.workintech.library;

public abstract class Books extends Library {

    private int Book_id;
    private Author author;
    private Type type;
    private String name;
    private double price;
    private String edition;

    public Books(int book_id, Author author, Type type, String name, double price, String edition) {
        Book_id = book_id;
        this.author = author;
        this.type = type;
        this.name = name;
        this.price = price;
        this.edition = edition;
    }


    public int getBook_id() {
        return Book_id;
    }

    public Author get_author() {
        return author;
    }

    public Type getType() {
        return type;
    }

    public String get_title() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getEdition() {
        return edition;
    }
}
