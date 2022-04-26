package io.hibernate.springdatajpa.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookNatural {
    @Id
    private String title;
    private String isbn;
    private String publisher;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
