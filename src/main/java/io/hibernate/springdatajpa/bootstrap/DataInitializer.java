package io.hibernate.springdatajpa.bootstrap;

import io.hibernate.springdatajpa.entity.Book;
import static io.hibernate.springdatajpa.entity.Book.BookBuilder;

import io.hibernate.springdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile({"local", "default", "dev"})
@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    
    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        
        Book bookDDD = new BookBuilder().title("Domain Driven Design 2014")
                               .author("Rando Author")
                               .isbn("1234")
                               .publisher("Random Publisher")
                               .authorId(1L)
                               .build();
        System.out.println("=========================================");
        System.out.println(bookDDD);
        System.out.println();
        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println(">>>>");
        System.out.println(savedDDD);
        System.out.println("=========================================");
        
        Book secondBookDDD = new BookBuilder().title("Spring In Action")
                                     .author("Oreilly")
                                     .isbn("4562671")
                                     .publisher("Second Random Publisher")
                                     .authorId(2L)
                                     .build();
        System.out.println("=========================================");
        System.out.println(secondBookDDD);
        
        Book savedBookDDD = bookRepository.save(secondBookDDD);
        System.out.println(">>>>>>");
        System.out.println(savedBookDDD);
        System.out.println("==========================================");
    
        System.out.println();
        System.out.println();
        
        
        bookRepository.findAll().forEach(x -> {
            System.out.println(">>>>>>");
            System.out.println(x);
        });
    
    }
}
