package io.hibernate.springdatajpa.testsplice;


import io.hibernate.springdatajpa.entity.Book;
import io.hibernate.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = "io.hibernate.springdatajpa.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSpliceTest {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Commit
    @Order(1)
    @Test
    protected void testJpaSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    
        Book newBook = new Book.BookBuilder().title("Test1")
                               .author("TestAuthor1")
                               .isbn("Test1234")
                               .publisher("TestPublisher1")
                               .build();
        bookRepository.save(newBook);
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
    
    @Order(2)
    @Test
    public void testJpaSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
