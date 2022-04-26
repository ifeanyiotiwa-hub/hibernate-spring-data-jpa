package io.hibernate.springdatajpa.bootstrap;

import io.hibernate.springdatajpa.entity.AuthorUuid;
import io.hibernate.springdatajpa.entity.Book;
import static io.hibernate.springdatajpa.entity.Book.BookBuilder;

import io.hibernate.springdatajpa.repository.AuthorUuidRepository;
import io.hibernate.springdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile({"local", "default", "dev"})
@Component
public class DataInitializer implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(DataInitializer.class);
    
    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    
    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorUuidRepository = authorUuidRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        
        Book bookDDD = new BookBuilder().title("Domain Driven Design 2014")
                               .author("Rando Author")
                               .isbn("1234")
                               .publisher("Random Publisher")
                               .authorId(1L)
                               .publisherId(0L)
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
                                     .publisherId(0L)
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
    
        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Johnson");
        authorUuid.setLastName("Thompson");
        AuthorUuid savedAuthorUuid = authorUuidRepository.save(authorUuid);
        LOG.info("Saved Author UUID: {}", savedAuthorUuid.getId());
    
    }
}
