package entity.concrete;

import java.time.LocalDate;
import java.util.Objects;

public class LoanRecord {

    private Long id;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean active;

    public LoanRecord(Long id, Book book, Member member, LocalDate borrowDate){
        this.id=id;
        this.book=book;
        this.member=member;
        this.borrowDate=borrowDate;
        this.returnDate=null;
        this.active=true;
    }

    public void closeRecord(LocalDate returnDate){
        this.returnDate=returnDate;
        this.active=false;
    }

    public Long getId(){
        return id;
    }

    public Book getBook(){
        return book;
    }

    public Member getMember(){
        return member;
    }

    public  LocalDate getBorrowDate(){
        return borrowDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }

    public boolean isActive(){
        return active;
    }

    @Override
    public String toString() {
        return "LoanRecord{" +
                "active=" + active +
                ", id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(obj ==null || obj.getClass() != getClass())
            return false;

        LoanRecord loanRecord = (LoanRecord) obj;

        return loanRecord.id.equals(this.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
}
