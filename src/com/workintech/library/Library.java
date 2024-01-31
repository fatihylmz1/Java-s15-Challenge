package com.workintech.library;

import com.workintech.library.Book.Books;
import com.workintech.library.Book.Type;
import com.workintech.library.Person.Author;
import com.workintech.library.Person.Reader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {
    private static List<Books> books;

    private Set<Reader> readers;

    public Library(List<Books> books, Set<Reader> readers) {
        this.books = new ArrayList<>();
        this.readers = new HashSet<>();
    }

    public static Books get_book(int bookId){

        if (books != null) {
            for (Books book : books) {
                if (book.getBook_id() == bookId) {
                    return book;
                }
            }
        }
        return null;
    }

    public void get_reader(Reader reader){
        readers.add(reader);
    }

    public  Books new_book(int id,String author, Type type, String name, double price, int edition){
        Books book = new Books(id,author,type,name,price,edition);
        books.add(book);
        return book;
    }

    public void lend_book(Books book,Reader reader){
        if(books.contains(book) && readers.contains(reader)){
            book.change_owner(reader);
            reader.borrow_book(book);
        }else{
            System.out.println("Kitap zaten alınmış.");
        }
    }

    public void take_back_book(Books book, Reader reader){
        if(books.contains(book) && readers.contains(reader)){
            book.change_owner(null);
            reader.return_book(book);
        }
    }

    public List<Books> show_books(){
        if (books == null){
            books = new ArrayList<>();
            System.out.println("Kütüphanede kitap bulunmamaktadır!");
        }else{

        for(Books book: books){
            System.out.println(book.display());
        }
        }

        return books;
    }
}