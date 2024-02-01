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
            System.out.println("\n---- Kütüphane Simülasyonu ----");
            System.out.println("1. Yeni kitap ekle.");
            System.out.println("2. Kitap ödünç al.");
            System.out.println("3. Kitap iade et.");
            System.out.println("4. Kütüphanedeki bütün kitapları göster.");
            System.out.println("5. Kütüphaneden kitap sil.");
            System.out.println("6. Kategoriye göre kitapları listele.");
            System.out.println("7. Yazar ismine göre kitapları listele.");
            System.out.println("8. Çıkış");
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");

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
                    removeBook(scanner,library);
                    break;
                case 6:
                    getBooksbyType(scanner,library);
                    break;
                case 7:
                    getBooksbyAuthor(scanner,library);
                    break;

                case 8:
                    System.out.println("Kütüphane simülasyonu kapatılıyor. Hoşçakalın!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız!");
            }
        }
    }
    /*
    * Kütüphane simülasyonuna yeni kitap ekler.
    * */
    private static void addNewBook(Scanner scanner, Library library) {
        System.out.print("Kitap ID'si giriniz: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Yazar ismi giriniz: ");
        String authorName = scanner.nextLine();

        System.out.print("Kitap kategorisini giriniz(JOURNALS, STUDYBOOKS, MAGAZINES): ");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Kitabın adını giriniz: ");
        String name = scanner.nextLine();

        System.out.print("Kitabın fiyatını giriniz: ");
        double price = scanner.nextDouble();

        System.out.print("Kitabın basım versiyonunu giriniz: ");
        int edition = scanner.nextInt();
        scanner.nextLine();

        Books newBook = new Books(bookId, authorName, type, name, price, edition);
        if(library.show_books().contains(newBook)){
            System.out.println("Bu kitap zaten eklenmiş!");
        }else{
        library.new_book(bookId,authorName,type,name,price,edition);
        System.out.println("Kitap başarıyla eklendi!");
        }

    }

    /*
    * Kütüphane simülasyonundan kitap ödünç almaya yarar.
    * */

    private static void borrowBook(Scanner scanner, Library library) {
        if(library != null){

        System.out.print("Ödünç almak istediğiniz kitabın id'sini giriniz: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Okuyucu adını giriniz: ");
        String readerName = scanner.nextLine();
        Reader reader = new Reader(readerName);

        Books book = library.get_book(bookId);


        if (book != null && reader.getBooks().size() <= 5) {
            library.lend_book(book,reader);
            book.change_owner(reader);
            System.out.println(reader + "Kullanıcısı tarafından kitap başarıyla alındı.");
        } else {
            System.out.println("Kitap bulunamadı!");
        }
        }else{
            System.out.println("Kütüphanede kitap bulunmamaktadır.");
        }
    }

    /*
    * Ödünç alınan kitabın iade edilmesini sağlar.
    * */

    private static void returnBook(Scanner scanner, Library library) {
        System.out.print("İade etmek istediğiniz kitabın id'sini giriniz: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Okuyucu adı giriniz: ");
        String readerName = scanner.nextLine();
        Reader reader = new Reader(readerName);

        Books book = library.get_book(bookId);

        if (book != null && book.getOwner() != null) {
            library.take_back_book(book,reader);
            System.out.println("Kitap başarıyla iade edildi!");
        } else {
            System.out.println("Kitap bulunamadı ya da daha önce ödünç alınmamış!");
        }
    }

    /*
    * Kütüphanede varolan bütün kitapları gösterir.
    * */

    private static void showAllBooks(Library library) {
        if(library != null){

        List<Books> books = library.show_books();

        if (books != null && books.isEmpty()) {
            System.out.println("Kütüphanede kitap bulunmamaktadır.");
        } else {
            System.out.println("---- KİTAPLAR ----");
            for (Books book : books) {
                System.out.println(book.display());;
            }
        }
        }
    }
    /*
    * Kütüphaneden kitap silme işlemi yapar.
    * */
    private static void removeBook(Scanner scanner,Library library){
        System.out.println("Silmek istediğiniz kitabın ID'sini giriniz:");
        int bookid = scanner.nextInt();
        Books book = library.get_book(bookid);
        library.remove_book(book);
        System.out.println("Kitap başarıyla silindi!");
    }

    /*
    * Kitap türüne göre filtreleme yapar.
    * */

    private static void getBooksbyType(Scanner scanner,Library library){
        System.out.println("Kitap kategorisini giriniz(JOURNALS, STUDYBOOKS, MAGAZINES)");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());
        library.displayBooksByType(type);

    }
    /*
    * Yazar ismine göre filtreleme yapar.
    * */
    private static void getBooksbyAuthor(Scanner scanner,Library library){
        System.out.println("Yazar ismi giriniz:");
        String author = scanner.nextLine();
        library.displayBooksByAuthor(author);

    }
    }
