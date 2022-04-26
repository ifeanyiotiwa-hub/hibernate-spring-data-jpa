package io.hibernate.springdatajpa.entity;


import com.google.common.base.MoreObjects;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Entity
public class BookUuid {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "")
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;
    private String title;
    private String isbn;
    private String publisher;
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public BookUuid(BookBuilder builder) {
        this.title = builder.title;
        this.isbn = builder.isbn;
        this.publisher = builder.publisher;
    }
    
    public BookUuid() {
    
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookUuid book = (BookUuid) o;
        return Objects.equals(id, book.id);
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title == null ? "" : title)
                .add("isbn", isbn == null ? "" : isbn)
                .add("publisher", publisher == null ? "" : publisher)
                .toString();
    }
    
    public static class BookBuilder {
        private String title;
        private String isbn;
        private String publisher;
        
        public BookBuilder title(String title){
            this.title = title;
            return this;
        }
        
        public BookBuilder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }
    
        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        public BookUuid build(){
            return new BookUuid(this);
        }
    }
}
