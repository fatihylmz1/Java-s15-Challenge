package com.workintech.library.Book;

import com.workintech.library.Person.Person;

import java.util.Objects;

public class Books {

    private int book_id;
    private String author;
    private Type type;
    private String name;
    private double price;
    private int edition;

    private Person owner;

    public Books(int book_id,String author, Type type, String name, double price, int edition) {
        this.author = author;
        this.type = type;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.book_id = book_id;
    }


    public int getBook_id() {
        return book_id;
    }

    public String get_author() {
        return author;
    }

    public Type getType() {
        return type;
    }

    public void change_owner(Person newOwner){
        this.owner=newOwner;
    }

    public Person getOwner() {
        return owner;
    }

    public String get_title() {
        return name;
    }

    public String display(){
        return "Book ID: " + book_id + ", Title: " + name + ", Author: " + author + ", Type: " + type +
                ", Owner: " + (owner != null ? getOwner() : "Alınabilir" );
    }

    public double getPrice() {
        return price;
    }

    public int getEdition() {
        return edition;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", edition=" + edition +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books books)) return false;
        return book_id == books.book_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id);
    }
}