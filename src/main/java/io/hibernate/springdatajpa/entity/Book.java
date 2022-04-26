package io.hibernate.springdatajpa.entity;


import com.google.common.base.MoreObjects;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private Long authorId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Book(BookBuilder builder) {
        this.title = builder.title;
        this.isbn = builder.isbn;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.authorId = builder.authorId;
    }
    
    public Book() {
    
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getAuthor() {
        return author;
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
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
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
                .add("author", author == null ? "" : author)
                .add("publisher", publisher == null ? "" : publisher)
                .toString();
    }
    
    public static class BookBuilder {
        public Long authorId;
        private Long id;
        private String title;
        private String isbn;
        private String author;
        private String publisher;
        
        public BookBuilder title(String title){
            this.title = title;
            return this;
        }
        
        public BookBuilder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }
    
        public BookBuilder author(String author){
            this.author = author;
            return this;
        }
    
        public BookBuilder publisher(String publisher){
            this.publisher = publisher;
            return this;
        }
        
        public BookBuilder authorId(Long authorId){
            this.authorId = authorId;
            return this;
        }
        
        public Book build(){
            return new Book(this);
        }
    }
}
