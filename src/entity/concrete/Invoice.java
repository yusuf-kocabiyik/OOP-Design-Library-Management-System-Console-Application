package entity.concrete;

import java.util.Objects;

public class Invoice {
    private Long id;
    private Book book;
    private Member member;
    private double amount;
    private boolean paid;
    private boolean refunded;

    public Invoice(Long id, Book book, Member member, double amount, boolean paid, boolean refunded){
        this.id=id;
        this.book=book;
        this.member=member;
        this.amount = amount;
        this.paid=paid;
        this.refunded=refunded;
    }

    public Long getId(){
        return this.id;
    }

    public Book getBook(){
        return this.book;
    }

    public Member getMember(){
        return this.member;
    }

    public double getAmount(){
        return  this.amount;
    }

    public boolean isPaid(){
        return this.paid;
    }

    public boolean isRefunded(){
        return this.refunded;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setBook(Book book){
        this.book=book;
    }

    public void setMember(Member member){
        this.member=member;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public void setPaid(boolean paid){
        this.paid=paid;
    }

    public void setRefunded(boolean refunded){
        this.refunded=refunded;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                ", invoiceId=" + id +
                "amount=" + amount +
                ", book=" + book +
                ", member=" + member +
                ", paid=" + paid +
                ", refunded=" + refunded +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Invoice invoice = (Invoice) obj;
        return invoice.id.equals(id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
