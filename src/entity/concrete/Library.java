package entity.concrete;

import entity.enums.BookStatus;
import entity.enums.Category;
import utils.StringUtils;


import java.util.*;

public class Library {
    private String name;
    private Map<Long,Book> books;
    private Map<Long, Member> members;
    private List<LoanRecord> loanRecordList;
    private List<Invoice> libraryInvoiceList;
    private  Long nextLoanRecordId = 1L;
    private  Long nextInvoiceId = 1L;

    public Library(String name){
        this.name=name;
        books = new HashMap<>();
        members = new HashMap<>();
        loanRecordList = new ArrayList<>();
        libraryInvoiceList = new ArrayList<>();
    }

    public Map<Long,Book> getBooks(){
        return Collections.unmodifiableMap(books);
    }

    public Map<Long, Member> getMembers(){
        return Collections.unmodifiableMap(members);
    }

    public List<LoanRecord> getLoanRecordList(){
        return Collections.unmodifiableList(loanRecordList);
    }

    public List<Invoice> getInvoiceList(){
        return Collections.unmodifiableList(libraryInvoiceList);
    }

    public String getName(){
        return this.name;
    }

    /// 1-)SİSTEME YENİ KİTAP EKLEME
    public void addBookToLibrary(Book book){
        if( book == null)
            throw new IllegalArgumentException("`book` arguments can not be null!");

        if( book.getId() == null)
            throw new IllegalArgumentException("`id` arguments can not be null!");

        if( book.getTitle() == null || book.getTitle().isBlank())
            throw new IllegalArgumentException("`book title` arguments can not be null or blank!");

        if( book.getAuthor() == null)
            throw new IllegalArgumentException("`book author` arguments can not be null!");

        Long id = book.getId();

        if(books.containsKey(id)){
            throw new IllegalArgumentException("Book with this id already exists. id: " + id);

        }

        books.put(id,book);
        //KÜTÜPHANEYE KİTAP EKLERKEN, KİTAP İLGİLİ YAZARIN KİTAP LİSTESİNE EKLENİYOR.
        book.getAuthor().addBook(book);
        System.out.println(book.getTitle() + " is added to library");

    }

    public void addMemberToLibrary( Member member){
        if(member == null)
            throw new IllegalArgumentException("`id or member` arguments can not be null!");
        Long id = member.getId();

        if (members.containsKey(id)){
            throw new IllegalArgumentException("Member with this id already exists. id: " + id);

        }

            members.put(id,member);
            System.out.println(member.getName()+" is added to library member list.");

    }

    public void addLoanRecord(LoanRecord loanRecord){
        if (loanRecord == null)
            throw new IllegalArgumentException("`loanRecord` argument can not be null!");

        if(!loanRecordList.contains(loanRecord)){
            loanRecordList.add(loanRecord);
            System.out.println(loanRecord.getMember() +" - "+" loanRecord with id:"+ loanRecord.getId() +" is added library loan record.");
        }
    }

    public void addInvoice(Invoice invoice){
        if (invoice == null)
            throw new IllegalArgumentException("`invoice` argument can not be null!");

        if (!libraryInvoiceList.contains(invoice)){
            libraryInvoiceList.add(invoice);
            System.out.println(invoice.getMember()+" - "+ invoice.getBook()+ " invoice is addded to library invoice list.");
        }

    }

    public void removeBookFromLibrary(Book book){
        if(book == null)
            throw new IllegalArgumentException("`book` argument can not be null!");

        Book removed = books.remove(book.getId());

        if(removed != null){
            System.out.println(book.getTitle() + " is removed from library book list");
        }else {
            System.out.println(book.getTitle() + " was not found in library book list!");
        }

    }

    public void removeMemberFromLibrary(Member member){

        if(member == null)
            throw new IllegalArgumentException("`member` argument can not be null!");

        Member removed = members.remove(member.getId());

        if(removed != null){
            System.out.println(member.getName()+ " - " +member.getId() + " is removed from library member list");
        }else {
            System.out.println(member.getName()+ " - " + member.getId() + " was not found in library member list");
        }

    }

    public void removeLoanRecord(LoanRecord loanRecord){

        if(loanRecord==null)
            throw new IllegalArgumentException("`loanRecord` argument can not be null");

        if(loanRecordList.remove(loanRecord)){
            System.out.println(loanRecord + " is removed from loan records");
        }else {
            System.out.println("Loanrecord was not found in loan records");
        }
    }

    public void removeInvoice(Invoice invoice){
        if(invoice==null)
            throw new IllegalArgumentException("`invoice` argument can not be null");

        if(libraryInvoiceList.remove(invoice)){
            System.out.println(invoice + " is removed from invoice list");
        }else {
            System.out.println("invoice was not found in invoice list");
        }

    }


    /// 2-) FIND BOOK BY ID
    public Book findBookById(Long id){
        if(id==null)
            throw new IllegalArgumentException("`id` argument can not be null");

        if(id<=0)
            throw new IllegalArgumentException("`id` argument can not be negative or zero");

        return books.get(id);
    }

    /// 2-) FIND BOOK BY NAME
    public List<Book> findBookByName(String title){
        if(title==null || title.isBlank())
            throw new IllegalArgumentException("`id` argument can not be null or blank");

        List<Book> foundBooks = new ArrayList<>();

        String cleanedTitle = StringUtils.normalize(title);

        for(Book book : books.values()){
            /*if(book.getTitle().equalsIgnoreCase(cleanedTitle)){
                foundBooks.add(book);
            }*/

            ///CONTAIN KULLANDIM İÇİNDE BİR KISMI GEÇİYORSA DA BULUNANLARI GETİRSİN
            if (StringUtils.normalize(book.getTitle()).contains(cleanedTitle)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /// 2-) FIND BOOK BY AUTHOR
    public List<Book> findBooksByAuthor(String authorName){
        if(authorName==null || authorName.isBlank())
            throw new IllegalArgumentException("`authorName` argument can not be null or blank");

        List<Book> foundBooks = new ArrayList<>();
        String cleanedAuthorName = StringUtils.normalize(authorName);

        for(Book book:books.values()){
            /*
            if(book.getAuthor()!=null && book.getAuthor().getName().equalsIgnoreCase(cleanedAuthorName)){
                foundBooks.add(book);
            }*/
            /// contains kullanarak aranan yazar tamamen yazılmasa da ilgili kitap bulunsun.
            if(book.getAuthor()!=null && StringUtils.normalize(book.getAuthor().getName()).contains(cleanedAuthorName)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /// 3-)KİTAP BİLGİLERİ GÜNCELLEME

    public Book updateBook(Long id, String title, Double price, Author author, Category category){
        Book bookToUpdate = findBookById(id);
        if(bookToUpdate ==null)
            throw new IllegalArgumentException("Book is not found with given id: " + id);

        if (title!=null && !title.isBlank()){
            bookToUpdate.setTitle(title);
        }

        if (price!=null){
            if (price<=0){
                throw new IllegalArgumentException("`price` can not be zero or negative");
            }
            bookToUpdate.setPrice(price);
        }

        if (author!=null && !author.getName().isBlank()){
            bookToUpdate.setAuthor(author);
        }

        if (category!=null){
            bookToUpdate.setCategory(category);
        }
        return bookToUpdate;
    }

    /// 4-)SİSTEMDE VAR OLAN BİR KİTAP SİLİNEBİLİR
    public Book deleteBook(Long id){
        if(id == null)
            throw new IllegalArgumentException("`id` argument can not be null");

        if(id <= 0)
            throw new IllegalArgumentException("`id` argument can not be negative or zero");

        Book bookToDelete = books.get(id);

        if(bookToDelete == null)
            throw new IllegalArgumentException("Book with given id not found");

        if(bookToDelete.getBorrowedBy()!= null)
            throw new IllegalArgumentException("Borrowed books can not be deleted before they are returned!");

        return books.remove(id);
    }

    /// 5-)SİSTEMDE VAR OLAN KİTAPLARI KATEGORİYE GÖRE LİSTELEME
    public List<Book> findBooksByCategory(Category category){
        if(category == null)
            throw new IllegalArgumentException("`Category` argument can not be null");
        List<Book> foundBooks = new ArrayList<>();

        for(Book book : books.values()){
            if(book.getCategory()==category){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /// 6-) SİSTEMDE VAR OLAN KİTAPLARI YAZARA GÖRE LİSTELEME
    /// BU İSTER 2. İSTERDE KARŞILANMIŞTIR !!!

    ///7-)ÖDÜNÇ KİTAP ALMA METODU

    public void borrowBook(Long bookId,Long memberId){
        if(bookId == null)
            throw new IllegalArgumentException("`bookId` argument can not be null");

        if(memberId == null)
            throw new IllegalArgumentException("`memberId` argument can not be null");

        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if(book == null){
            //System.out.println("Book with given id not found");
            //return;
            throw new IllegalArgumentException("Book with given id not found, id: " + bookId);
        }


        if(member == null){
            //System.out.println("Member with given id not found");
            //return;
            throw new IllegalArgumentException("Member with given id not found, id: " + memberId);

        }

        if(book.getBorrowedBy() != null && book.getBorrowedBy().equals(member)){
           // System.out.println("Related member has this book already, book can not be borrowed before it returned!");
           // return;
            throw new IllegalArgumentException("Related member has this book already, book can not be borrowed before it returned!");
        }

        if(book.getBorrowedBy() != null || book.getBookStatus() == BookStatus.BORROWED){
           // System.out.println("Book is already borrowed");
           // return;
            throw new IllegalArgumentException("Book: "+ book.getTitle() +" is already borrowed");
        }

        if(member.getBorrowedBooks().size()>=Member.getMaxBookLimit()){
            //System.out.println("Member can not borrow more than 5 books");
           // return;
            throw new IllegalArgumentException("Member can not borrow more than 5 books");
        }
        /// KONTROLLERİ GEÇTİKTEN SONRA
        /// SET İŞLEMLERİNİ BURADA YAPIYORUZ
        book.setBorrowedBy(member);
        book.setBookStatus(BookStatus.BORROWED);
        member.addBorrowedBook(book);

        LoanRecord loanRecord = new LoanRecord(nextLoanRecordId++,book,member,java.time.LocalDate.now());
        addLoanRecord(loanRecord);
        System.out.println("Loan record / ödünç kaydı oluşturuldu: " + loanRecord);

        Invoice invoice = new Invoice(nextInvoiceId++,book,member,book.getPrice(),true,false);
        addInvoice(invoice);
        member.addInvoice(invoice);
        System.out.println("Invoice is created: " + invoice);
        System.out.println(book.getTitle() + " kitabı " + member.getId() +" id'li " + member.getName() + " kişisine ödünç verildi.");

    }

    /// BURAYA İADE İŞLEMLERİNDE İLGİLİ ÜYENİN LOAN RECORD VE INVOICE NU BULMAK İÇİN İKİ TANE METOT EKLİYORUZ.
    public LoanRecord findActiveLoanRecord(Book book, Member member){
        for (LoanRecord loanRecord : loanRecordList){
            if(loanRecord.getBook().equals(book) && loanRecord.getMember().equals(member) && loanRecord.isActive()) {
                return loanRecord;
            }
        }
        return null;
    }
    /// BURAYA İADE İŞLEMLERİNDE İLGİLİ ÜYENİN LOAN RECORD VE INVOICE NU BULMAK İÇİN İKİ TANE METOT EKLİYORUZ.
    public Invoice findActiveInvoice(Book book, Member member){
        for(Invoice invoice : libraryInvoiceList){
            if(invoice.getBook().equals(book)
                    && invoice.getMember().equals(member)
                    && invoice.isPaid()
                    && !invoice.isRefunded()){
                return invoice;
            }
        }
        return null;
    }

    /// 8-) KİTAP İADE ETME METODU

    public void returnBook(Long bookId,Long memberId){
        if(bookId ==null)
            throw new IllegalArgumentException("`bookId` argument can not be null");

        if(memberId == null)
            throw new IllegalArgumentException("`memberId` argument can not be null");

        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if(book == null)
            throw new IllegalArgumentException("Book with given id not found in the library, id: " + bookId);

        if(member == null)
            throw new IllegalArgumentException("Member with given id is not registered to this library, id: " + memberId );

        if(book.getBorrowedBy() == null || book.getBookStatus() ==BookStatus.AVAILABLE)
            throw new IllegalArgumentException("Book is not borrowed by this member");

        if(!member.equals(book.getBorrowedBy()))
            throw new IllegalArgumentException("This book: "+ book.getTitle() +" is not borrowed by this member: " + member.getName());

        LoanRecord loanRecord = findActiveLoanRecord(book,member);
        if(loanRecord != null){
            loanRecord.closeRecord(java.time.LocalDate.now());
        }

        Invoice invoice = findActiveInvoice(book,member);
        if(invoice !=null){
            invoice.setRefunded(true);
        }

        member.removeBorrowedBook(book);
        book.setBorrowedBy(null);
        book.setBookStatus(BookStatus.AVAILABLE);
        System.out.println(book.getTitle() + " kitabı " + member.getId() + " id'li " + member.getName() + " tarafından iade edildi." );
        if (invoice !=null){
            System.out.println("Refund processed for invoice id: " + invoice.getId());
        }
    }

    @Override
    public String toString(){
        return "Library : " + this.name;
    }


}
