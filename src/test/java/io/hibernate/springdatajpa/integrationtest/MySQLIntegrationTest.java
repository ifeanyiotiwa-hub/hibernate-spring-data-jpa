package io.hibernate.springdatajpa.integrationtest;

import io.hibernate.springdatajpa.entity.AuthorUuid;
import io.hibernate.springdatajpa.entity.BookNatural;
import io.hibernate.springdatajpa.entity.BookUuid;
import io.hibernate.springdatajpa.repository.AuthorUuidRepository;
import io.hibernate.springdatajpa.repository.BookNaturalRepository;
import io.hibernate.springdatajpa.repository.BookRepository;
import io.hibernate.springdatajpa.repository.BookUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "io.hibernate.springdatajpa.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    BookUuidRepository bookUuidRepository;
    
    @Autowired
    AuthorUuidRepository authorUuidRepository;
    @Autowired
    BookNaturalRepository bookNaturalRepository;
    
    
    @Test
    public void testBookNatural() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("Book Natural");
        BookNatural savedBookNatural = bookNaturalRepository.save(bookNatural);
        assertThat(savedBookNatural).isNotNull();
        assertThat(savedBookNatural.getTitle()).isEqualTo("Book Natural");
        
        BookNatural fetched = bookNaturalRepository.getById(savedBookNatural.getTitle());
        assertThat(fetched).isNotNull();
        assertThat(fetched).isEqualTo(savedBookNatural);
    }
    
    @Test
    public void testMySQL() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
    
    @Test
    public void testAuthorUuid() {
        long count = authorUuidRepository.count();
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid("Chika", "Nwobi"));
        long finalCount = authorUuidRepository.count();
        assertThat(authorUuid).isNotNull();
        assertThat(count).isLessThan(finalCount);
        
        AuthorUuid fetched = authorUuidRepository.getById(authorUuid.getId());
        assertThat(fetched).isNotNull();
        assertThat(fetched).isEqualTo(authorUuid);
    }
    
    @Test
    public void testSavedBookUuid() {
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid.BookBuilder().title("Test title").build());
        assertThat(bookUuid.getId()).isNotNull();
    }
}
