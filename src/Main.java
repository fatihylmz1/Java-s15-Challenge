import com.workintech.library.Book.Books;
import com.workintech.library.Book.Type;
import com.workintech.library.Library;
import com.workintech.library.Person.Author;
import com.workintech.library.Person.Person;
import com.workintech.library.Person.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Person author1 = new Author("Charles K. Alexander");
        Books book1 = new Books(1,"Charles K. Alexander", Type.STUDYBOOKS,"Fundamentals of Electric",45.50,2);
        Reader reader1 = new Reader("Fatih Yılmaz");

        List<Books> book = new ArrayList<>();
        book.add(book1);
        Set<Reader> reader = new HashSet<>();
        reader.add(reader1);

        Library library = new Library(book,reader);

        while (true) {
            System.out.println("\n---- Library Management System ----");
            System.out.println("1. Add a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show all books");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewBook(scanner, library);
                    break;
                case 2:
                    borrowBook(scanner, library);
                    break;
                case 3:
                    returnBook(scanner, library);
                    break;
                case 4:
                    showAllBooks(library);
                    break;
                case 5:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void addNewBook(Scanner scanner, Library library) {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter book type(JOURNALS, STUDYBOOKS, MAGAZINES): ");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter book name: ");
        String name = scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter book edition: ");
        int edition = scanner.nextInt();
        scanner.nextLine();

        Books newBook = new Books(bookId, authorName, type, name, price, edition);
        library.new_book(bookId,authorName,type,name,price,edition);

        System.out.println("Book added successfully!");
    }

    private static void borrowBook(Scanner scanner, Library library) {
        if(library != null){

        System.out.print("Enter book ID to borrow: ");
        int bookId = scanner.nextInt();
            scanner.nextLine();

        System.out.print("Enter reader name: ");
        String readerName = scanner.nextLine();
        Reader reader = new Reader(readerName);

        Books book = library.get_book(bookId);


        if (book != null) {
            library.lend_book(book,reader);
            book.change_owner(reader);
            System.out.println("Kitap başarıyla satın alındı.");
        } else {
            System.out.println("Kitap bulunamadı!");
        }
        }else{
            System.out.println("Kütüphanede kitap bulunmamaktadır.");
        }
    }

    private static void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();
        System.out.print("Enter reader name: ");
        String readerName = scanner.nextLine();
        Reader reader = new Reader(readerName);

        Books book = library.get_book(bookId);

        if (book != null && book.getOwner() != null) {
            library.take_back_book(book,reader);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found or not borrowed!");
        }
    }

    private static void showAllBooks(Library library) {
        if(library != null){

        List<Books> books = library.show_books();

        if (books != null && books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("---- All Books in the Library ----");
            for (Books book : books) {
                System.out.println(book.display());;
            }
        }
        }
    }
    }
