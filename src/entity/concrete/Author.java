package entity.concrete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Author {
    private Long id;
    private String name;
    private List<Book> books = new ArrayList<>();

    public Author(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void addBook(Book book){
        if(book == null)
            throw new IllegalArgumentException("`book` argument cannot be null!");

        if(this.equals(book.getAuthor()) && !books.contains(book))
            this.books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    @Override
    public String toString(){
        return "Author : " + name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Author author = (Author) obj;
        return author.id.equals(id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}
