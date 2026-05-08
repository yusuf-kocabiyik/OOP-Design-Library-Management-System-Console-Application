package main;

import com.sun.security.jgss.GSSUtil;
import entity.Person;
import entity.concrete.*;
import entity.enums.BookStatus;
import entity.enums.Category;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainLibray {
    public static void main(String[] args) {

        /*Person p1 = new Librarian(1L,"librarian ahmet");
        Person p2 = new StudentMember(1L,"member ali","ali-test.com");
        System.out.println(p1.getRole());
        System.out.println(p2.getRole());*/

        /// MADDE 1-2-3-4-5-6 MANUAL TESTLER
         /*
        System.out.println(myLibrary.getBooks());
        System.out.println(victorHugo.getBooks());
        System.out.println("----------------------------------");
        System.out.println("id ile arama: ");
        System.out.println(myLibrary.findBookById(201L));

        System.out.println("name ile arama: ");
       //System.out.println(myLibrary.findBookByName("Sefiller"));
        // System.out.println(myLibrary.findBookByName("Sefi"));
        System.out.println("author ile arama: ");
        //System.out.println(myLibrary.findBookByAuthor("Victor Hugo"));
        System.out.println(myLibrary.findBooksByAuthor("Victo"));

        System.out.println("**************************");
        myLibrary.updateBook(202L,"Notre Dame",75.5,victorHugo,Category.NOVEL);

        System.out.println(myLibrary.deleteBook(202L));
        System.out.println("***********************");
        System.out.println(myLibrary.getBooks());
        */

        /// MADDE 7-ÖDÜNÇ ALMA 8-İADE ETME 9-INVOICE/FİŞ KESİLME VE ÖDÜNÇ KAYDININ OLUŞTURULMASI
        /// MADDELERİNİN MANUEL TESTLERİ
        /*
        /// KÜTÜPHANE OBJESİ OLUŞTURULUYOR
        Library myLibrary = new Library("Merkez Kütüphane");
        System.out.println(myLibrary.getName());

        /// YAZARLAR VE KİTAPLAR OLUŞTURULUYOR
        Author doganCuceloglu = new Author(1L,"Dogan Cüceloglu");
        Book savasci =new Book(101L,"Savaşçı",
                20.0,doganCuceloglu, Category.SELFHELP, BookStatus.AVAILABLE,null);


        Author victorHugo = new Author(2L,"Victor Hugo");
        Book sefiller =new Book(201L,"Sefiller",
                25.0,victorHugo,Category.NOVEL,BookStatus.AVAILABLE,null);
        Book notreDameinKamburu = new Book(202L,"Notre Dame'ın Kamburu",
                26.0,victorHugo,Category.NOVEL,BookStatus.AVAILABLE,null);

        Author carlSagan = new Author(3L,"Carl Sagan");
        Book kozmoz = new Book(301L,"Kozmoz",
                35.5,carlSagan,Category.SCIENCE,BookStatus.AVAILABLE,null);

        Author isaacAsimov = new Author(4L,"Isaac Asimov");
        Book benRobot = new Book(401L,"Ben Robot",
                42.7,isaacAsimov,Category.SCIENCE,BookStatus.AVAILABLE,null);

        Author stephenHawking = new Author(5L,"Stephen Hawking");
        Book evren = new Book(501L,"Evren",
                100.8,stephenHawking,Category.HISTORY,BookStatus.AVAILABLE,null);

        Author richardFeynman = new Author(6L,"Richard Feynman");
        Book kesfet = new Book(601L,"Kesfet",
                120.5,richardFeynman,Category.TECHNOLOGY,BookStatus.AVAILABLE,null);

        Author nikolaTesla = new Author(7L,"Nikola Tesla");
        Book acCurrent = new Book(701L,"AC Current",
                140.5,richardFeynman,Category.TECHNOLOGY,BookStatus.AVAILABLE,null);

        Author zulfuLivaneli = new Author(8L,"Zülfü Livaneli");
        Book serenad = new Book(801L,"Serenad",
                180.8,zulfuLivaneli,Category.NOVEL,BookStatus.AVAILABLE,null);

        Book sonAda = new Book(802L,"Son Ada",
                250.8,zulfuLivaneli,Category.NOVEL,BookStatus.AVAILABLE,null);


        ///  KİTAPLAR KÜTÜPHANEYE EKLENİYOR
        myLibrary.addBookToLibrary(savasci);
        myLibrary.addBookToLibrary(sefiller);
        myLibrary.addBookToLibrary(notreDameinKamburu);
        myLibrary.addBookToLibrary(kozmoz);
        myLibrary.addBookToLibrary(benRobot);
        myLibrary.addBookToLibrary(evren);
        myLibrary.addBookToLibrary(kesfet);
        myLibrary.addBookToLibrary(acCurrent);
        myLibrary.addBookToLibrary(serenad);
        myLibrary.addBookToLibrary(sonAda);

        /// MEMBER LAR OLUŞTURULUYOR
        Member ali = new Member(1L,"Ali","ali@test.com");
        Member ayse = new Member(2L,"Ayse","ayse@test.com");
        Member yusuf = new Member(3L,"Yusuf","yusuf@test.com");

        /// LİBRARY E MEMBER EKLENİYOR
        System.out.println("\nMEMBERS EKLENİYOR");
        myLibrary.addMemberToLibrary(ali);
        myLibrary.addMemberToLibrary(ayse);
        myLibrary.addMemberToLibrary(yusuf);


        /// 7-) KİTAP ÖDÜNÇ ALMA MADDESİNİN MANUAL TESTLERİ
        /// TEST 1 BAŞARILI ÖDÜNÇ ALMA
        try{
            System.out.println("\n TEST 1 - Başarılı ödünç alma ");
            myLibrary.borrowBook(101L,1L);

            System.out.println("Kitabın borrowedBy bilgisi: " + savasci.getBorrowedBy());
            System.out.println("Kitabın status bilgisi: " + savasci.getBookStatus());
            System.out.println("Ali nin aldığı kitaplar: " + ali.getBorrowedBooks());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 2 AYNI KİTABI BAŞKA BİRİ ALMAYA ÇALIŞIYOR
        try{
            System.out.println("\nTEST2 - Aynı kitabı başa biri almaya çalışıyor.");
            myLibrary.borrowBook(101L,2L);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 3 - Aynı member aynı kitabı tekrar almaya çalışıyor
        try{
            System.out.println("\nTEST 3 - Aynı member aynı kitabı tekrar almaya çalışıyor");
            myLibrary.borrowBook(101L, 1L);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 4 - Olmayan kitap id
        try {
            System.out.println("\nTEST 4 - Olmayan kitap id");
            myLibrary.borrowBook(999L, 1L);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        /// TEST 5 - Olmayan member id
        try {
            System.out.println("\nTEST 5 - Olmayan member id");
            myLibrary.borrowBook(201L, 999L);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TEST 6 - 5 kitap limit testi
        // -----------------------------------------
        try {
            System.out.println("\nTEST 6 - 5 kitap limiti testi");

            myLibrary.borrowBook(201L, 2L);
            System.out.println("*****************************************");
            myLibrary.borrowBook(202L, 2L);
            System.out.println("*****************************************");
            myLibrary.borrowBook(301L, 2L);
            System.out.println("*****************************************");
            myLibrary.borrowBook(401L, 2L);
            System.out.println("*****************************************");
            myLibrary.borrowBook(501L, 2L);
            System.out.println("*****************************************");

            System.out.println("Ayşe'nin ödünç aldığı kitaplar: " + ayse.getBorrowedBooks());

            //6. kitap denemesi
            myLibrary.borrowBook(601L, 2L);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        /// TEST 7 - Son durum kontrolü
        System.out.println("\nTEST 7 - Son durum kontrolü");
        System.out.println("Ali'nin kitapları: " + ali.getBorrowedBooks());
        System.out.println("Ayşe'nin kitapları: " + ayse.getBorrowedBooks());
        System.out.println("Yusuf'un kitapları: " + yusuf.getBorrowedBooks());
        System.out.println("Library books: " + myLibrary.getBooks());

        ///8-) KİTAP İADE ETME MADDESİNİN MANUAL TESTLERİ
        /// BAŞARILI KİTAP İADESİ
        try{
            System.out.println("\nTEST8 - Başarılı kitap iadesi");
            myLibrary.returnBook(101L,1L);

            System.out.println("Kitabın borrowedBy bilgisi: " + savasci.getBorrowedBy());
            System.out.println("Kitabın status bilgisi: " + savasci.getBookStatus());
            System.out.println("Ali'nin kitapları: " + ali.getBorrowedBooks());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        /// TEST 9 - Aynı kitap tekrar iade edilmeye çalışılıyor
        try{
            System.out.println("\nTEST 9 - Aynı kitap tekrar iade edilmeye çalışılıyor");
            myLibrary.returnBook(101L,1L);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 10 - Kitabı almayan kişi iade etmeye çalışıyor
        try{
            System.out.println("\nTEST 10 - Kitabı almayan kişi iade etmeye çalışıyor");

            myLibrary.borrowBook(601L,3L);   // önce Yusuf alsın
            myLibrary.returnBook(601L,2L);   // sonra Ayşe iade etmeye çalışsın

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 11 - Olmayan kitap id ile iade
        try{
            System.out.println("\nTEST 11 - Olmayan kitap id ile iade");
            myLibrary.returnBook(999L,1L);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        /// TEST 12 - Olmayan member id ile iade
        try{
            System.out.println("\nTEST 12 - Olmayan member id ile iade");
            myLibrary.returnBook(201L,999L);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println(myLibrary.getLoanRecordList());
        System.out.println("*****************************************");
        System.out.println(myLibrary.getInvoiceList());
        System.out.println("*****************************************");
        System.out.println(myLibrary.getMembers());
        */

///------------------------------------------------------------------------------------

        /// KONSOL UYGULAMASI
        Library library = new Library("Merkez Kütüphane");
        Scanner scanner = new Scanner(System.in);

        seedData(library);
        boolean running = true;

        while(running){
            printMenu();
            System.out.println("Seçiminiz: ");
            String choice = scanner.nextLine();

            try{
                switch (choice){
                    case "1":
                        handleAddBook(scanner,library);
                        break;
                    case "2":
                        handleAddMember(scanner,library);
                        break;
                    case "3":
                        handleFindBookById(scanner, library);
                        break;
                    case "4":
                        handleFindBookByName(scanner, library);
                        break;
                    case "5":
                        handleFindBooksByAuthor(scanner, library);
                        break;
                    case "6":
                        handleFindBooksByCategory(scanner, library);
                        break;
                    case "7":
                        handleUpdateBook(scanner, library);
                        break;
                    case "8":
                        handleDeleteBook(scanner, library);
                        break;
                    case "9":
                        handleBorrowBook(scanner, library);
                        break;
                    case "10":
                        handleReturnBook(scanner, library);
                        break;
                    case "11":
                        handleListAllBooks(library);
                        break;
                    case "12":
                        handleListAllMembers(library);
                        break;
                    case "13":
                        handleListInvoices(library);
                        break;
                    case "0":
                        running=false;
                        System.out.println("Uygulamadan çıkılıyor...");
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                }
            }catch (Exception e){
                System.out.println("Hata: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void printMenu(){
        System.out.println("\n========= KÜTÜPHANE MENÜSÜ =========");
        System.out.println("1 - Yeni kitap ekle");
        System.out.println("2 - Yeni üye ekle");
        System.out.println("3 - Kitabı id ile bul");
        System.out.println("4 - Kitabı isim ile bul");
        System.out.println("5 - Yazara göre kitapları listele");
        System.out.println("6 - Kategoriye göre kitapları listele");
        System.out.println("7 - Kitap güncelle");
        System.out.println("8 - Kitap sil");
        System.out.println("9 - Kitap ödünç al");
        System.out.println("10 - Kitap iade et");
        System.out.println("11 - Tüm kitapları listele");
        System.out.println("12 - Tüm üyeleri listele");
        System.out.println("13 - Faturaları listele");
        System.out.println("0 - Çıkış");
    }

    public static void seedData(Library library){
        Author victorHugo = new Author(1L, "Victor Hugo");
        Author carlSagan = new Author(2L, "Carl Sagan");

        Book b1 = new Book(101L, "Sefiller", 25.0, victorHugo, Category.NOVEL, BookStatus.AVAILABLE, null);
        Book b2 = new Book(102L, "Notre Dame'in Kamburu", 30.0, victorHugo, Category.NOVEL, BookStatus.AVAILABLE, null);
        Book b3 = new Book(103L, "Kozmos", 20.0, carlSagan, Category.SELFHELP, BookStatus.AVAILABLE, null);

        library.addBookToLibrary(b1);
        library.addBookToLibrary(b2);
        library.addBookToLibrary(b3);

        Member m1 = new Member(1L, "Ali", "ali@test.com");
        Member m2 = new Member(2L, "Ayse", "ayse@test.com");

        library.addMemberToLibrary(m1);
        library.addMemberToLibrary(m2);
    }

    public static void handleAddBook(Scanner scanner,Library library){
        System.out.println("Kitap id: ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("Kitap adı: ");
        String title = scanner.nextLine();

        System.out.println("Fiyat: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Yazar id: ");
        Long authorId = Long.parseLong(scanner.nextLine());

        System.out.print("Yazar adı: ");
        String authorName = scanner.nextLine();

        System.out.println("Kategori seçenekleri:");
        for (Category category : Category.values()) {
            System.out.println("- " + category.name());
        }
        System.out.print("Kategori: ");
        Category category = Category.valueOf(scanner.nextLine().toUpperCase());
        Author author = new Author(authorId,authorName);
        Book book = new Book(id,title,price,author,category,BookStatus.AVAILABLE,null);
        library.addBookToLibrary(book);
        System.out.println("Kitap başarıyla kütüphaneye eklendi.");
    }

    public static void handleAddMember(Scanner scanner,Library library){
        System.out.println("Üye id: ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.print("Üye adı: ");
        String name = scanner.nextLine();

        System.out.print("Üye email: ");
        String email = scanner.nextLine();

        Member member = new Member(id, name, email);
        library.addMemberToLibrary(member);

        System.out.println("Üye başarıyla eklendi.");
    }

    public static void handleFindBookById(Scanner scanner, Library library) {
        System.out.print("Kitap id: ");
        Long id = Long.parseLong(scanner.nextLine());

        Book book = library.findBookById(id);

        if (book == null) {
            System.out.println("Bu id ile kitap bulunamadı.");
            return;
        }

        System.out.println("Bulunan kitap: " + book);
    }

    public static void printBookList(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Sonuç bulunamadı.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void handleFindBookByName(Scanner scanner, Library library) {
        System.out.print("Kitap adı: ");
        String title = scanner.nextLine();

        List<Book> foundBooks = library.findBookByName(title);

        if (foundBooks.isEmpty()) {
            System.out.println("Bu isme uygun kitap bulunamadı.");
            return;
        }

        System.out.println("Bulunan kitaplar:");
        for (Book book : foundBooks) {
            System.out.println(book);
        }
    }

    public static void handleFindBooksByAuthor(Scanner scanner, Library library) {
        System.out.print("Yazar adı: ");
        String authorName = scanner.nextLine();

        List<Book> foundBooks = library.findBooksByAuthor(authorName);

        if (foundBooks.isEmpty()) {
            System.out.println("Bu yazara ait kitap bulunamadı.");
            return;
        }

        System.out.println("Yazara ait kitaplar:");
        for (Book book : foundBooks) {
            System.out.println(book);
        }
    }

    public static void handleFindBooksByCategory(Scanner scanner, Library library) {
        System.out.println("Kategori seçenekleri:");
        for (Category category : Category.values()) {
            System.out.println("- " + category.name());
        }

        System.out.print("Kategori: ");
        Category category = Category.valueOf(scanner.nextLine().toUpperCase());

        List<Book> foundBooks = library.findBooksByCategory(category);
        printBookList(foundBooks);
    }

    public static void handleUpdateBook(Scanner scanner, Library library) {
        System.out.print("Güncellenecek kitap id: ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.print("Yeni başlık : ");
        String title = scanner.nextLine();
        if (title.isBlank()) {
            title = null;
        }

        System.out.print("Yeni fiyat : ");
        String priceInput = scanner.nextLine();
        Double price = priceInput.isBlank() ? null : Double.parseDouble(priceInput);

        System.out.print("Yeni yazar id : ");
        String authorIdInput = scanner.nextLine();
        Author author = null;

        if (!authorIdInput.isBlank()) {
            Long authorId = Long.parseLong(authorIdInput);
            System.out.print("Yeni yazar adı: ");
            String authorName = scanner.nextLine();
            author = new Author(authorId, authorName);
        }

        System.out.print("Yeni kategori : ");
        String categoryInput = scanner.nextLine();
        Category category = categoryInput.isBlank() ? null : Category.valueOf(categoryInput.toUpperCase());

        Book updatedBook = library.updateBook(id, title, price, author, category);
        System.out.println("Güncellenen kitap: " + updatedBook);
    }

    public static void handleDeleteBook(Scanner scanner, Library library) {
        System.out.print("Silinecek kitap id: ");
        Long id = Long.parseLong(scanner.nextLine());

        Book deletedBook = library.deleteBook(id);
        System.out.println("Silinen kitap: " + deletedBook);
    }

    public static void handleBorrowBook(Scanner scanner, Library library) {
        System.out.print("Kitap id: ");
        Long bookId = Long.parseLong(scanner.nextLine());

        System.out.print("Üye id: ");
        Long memberId = Long.parseLong(scanner.nextLine());

        library.borrowBook(bookId, memberId);
        System.out.println("Ödünç alma işlemi tamamlandı.");
    }

    public static void handleReturnBook(Scanner scanner, Library library) {
        System.out.print("İade edilecek kitap id: ");
        Long bookId = Long.parseLong(scanner.nextLine());

        System.out.print("Üye id: ");
        Long memberId = Long.parseLong(scanner.nextLine());

        library.returnBook(bookId, memberId);
        System.out.println("Kitap iade işlemi tamamlandı.");
    }

    public static void handleListAllBooks(Library library) {
        if (library.getBooks().isEmpty()) {
            System.out.println("Kütüphanede hiç kitap yok.");
            return;
        }

        System.out.println("\n--- TÜM KİTAPLAR ---");
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }
    }

    public static void handleListAllMembers(Library library) {
        if (library.getMembers().isEmpty()) {
            System.out.println("Kütüphanede kayıtlı üye yok.");
            return;
        }

        System.out.println("\n--- TÜM ÜYELER ---");
        for (Member member : library.getMembers().values()) {
            System.out.println(member);
        }
    }

    public static void handleListInvoices(Library library) {
        if (library.getInvoiceList().isEmpty()) {
            System.out.println("Henüz fatura bulunmuyor.");
            return;
        }

        System.out.println("\n--- TÜM FATURALAR ---");
        for (Invoice invoice : library.getInvoiceList()) {
            System.out.println(invoice);
        }



    }


}