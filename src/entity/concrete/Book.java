package entity.concrete;

import entity.enums.BookStatus;
import entity.enums.Category;

import java.util.Objects;

public class Book {
    private Long id;
    private String title;
    private Double price;
    private Author author;
    private Category category;
    private BookStatus bookStatus;
    private Member borrowedBy;

    public Book(Long id, String title, Author author,Category category){
        this.id=id;
        this.title=title;
        this.author=author;
        this.category=category;
        this.bookStatus = BookStatus.AVAILABLE;
    }
    public Book(Long id, String title, double price, Author author, Category category, BookStatus bookStatus, Member borrowedBy){
        this.id=id;
        this.title=title;
        this.price=price;
        this.author=author;
        this.category=category;
        this.bookStatus=bookStatus;
        this.borrowedBy=borrowedBy;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public double getPrice(){
        return this.price;
    }

    public Author getAuthor(){
        return this.author;
    }
    public Category getCategory(){
        return this.category;
    }

    public BookStatus getBookStatus(){
        return this.bookStatus;
    }

    public Member getBorrowedBy(){
        return this.borrowedBy;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setAuthor(Author author){
        this.author=author;
    }

    public void setCategory(Category category){
        this.category=category;
    }

    public void setBookStatus(BookStatus bookStatus){
        this.bookStatus=bookStatus;
    }

    public void setBorrowedBy(Member borrowedBy){
        this.borrowedBy=borrowedBy;
    }

    @Override
    public String toString(){
        return "Book:" + title +" | " + " id:" + id;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return  true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Book book = (Book) obj;
        return book.id.equals(id);

    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
