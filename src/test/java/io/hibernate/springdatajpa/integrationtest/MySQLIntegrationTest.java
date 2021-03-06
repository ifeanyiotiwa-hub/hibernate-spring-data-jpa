package io.hibernate.springdatajpa.integrationtest;

import io.hibernate.springdatajpa.entity.AuthorUuid;
import io.hibernate.springdatajpa.entity.BookNatural;
import io.hibernate.springdatajpa.entity.BookUuid;
import io.hibernate.springdatajpa.entity.composite.AuthorComposite;
import io.hibernate.springdatajpa.entity.composite.AuthorEmbedded;
import io.hibernate.springdatajpa.entity.composite.NameId;
import io.hibernate.springdatajpa.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

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
    
    @Autowired
    AuthorCompositeRepository authorCompositeRepository;
    
    @Autowired AuthorEmbeddedRepository authorEmbeddedRepository;
    
    
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
    
    @Test
    public void testAuthorComposite() {
        NameId nameId = new NameId("Johnson", "T");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("US");
        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();
        
        AuthorComposite fetched = authorCompositeRepository.getById(nameId);
        assertThat(fetched).isNotNull();
    }
    
    @Test
    public void testAuthorEmbedded() {
        NameId nameId = new NameId("Johnson", "T");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId);
        AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(saved).isNotNull();
        
        AuthorEmbedded fetched = authorEmbeddedRepository.getById(nameId);
        assertThat(fetched).isNotNull();
        assertThat(fetched).isEqualTo(saved);
    }
}
