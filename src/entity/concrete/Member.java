package entity.concrete;

import entity.Person;

import java.util.*;


public class Member extends Person {
    private String email;
    private Set<Book> borrowedBooksSet = new HashSet<>();
    private List<Invoice> invoiceList = new ArrayList<>();
    private static final int MAX_BOOK_LIMIT = 5;



    public Member(Long id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public Set<Book> getBorrowedBooks(){
        return Collections.unmodifiableSet(borrowedBooksSet);
    }

    public List<Invoice> getInvoiceList(){
        return Collections.unmodifiableList(invoiceList);
    }
    public static int getMaxBookLimit(){
        return MAX_BOOK_LIMIT;
    }

    @Override
    public String getRole() {
        return "entity.concrete.Member";
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void addBorrowedBook(Book book){
        if(book == null)
            throw new IllegalArgumentException("`book` argument can not be null!");

        /*if(!this.equals(book.getBorrowedBy()))
            return;*/

        if(!borrowedBooksSet.contains(book) && borrowedBooksSet.size()>=MAX_BOOK_LIMIT)
            throw new IllegalArgumentException("Member can not borrow more than 5 books!");


        borrowedBooksSet.add(book);
        System.out.println(book.getTitle() + " is added member borrowed book set.");
    }

    public void removeBorrowedBook(Book book){
        borrowedBooksSet.remove(book);
    }

    public void addInvoice(Invoice invoice){
        if(invoice == null)
            throw new IllegalArgumentException("`invoice` argument can not be null!");

        if(this.equals(invoice.getMember())  && !invoiceList.contains(invoice)){
            invoiceList.add(invoice);
            System.out.println(invoice.getMember() + " - "  + " related invoice with id:"+ invoice.getId()+ " added to member's invoice list.");
        }

    }

    public void removeInvoice(Invoice invoice){
        invoiceList.remove(invoice);
    }

    @Override
    public String toString(){
        return "Member : " + getName();
    }
}
