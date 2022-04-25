package io.hibernate.springdatajpa;

import io.hibernate.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringdatajpaApplicationTests {
    
    @Autowired
    BookRepository testRepository;
    
    
    @Test
    void testBookRepository() {
        long count = testRepository.count();
        
        assertThat(count).isGreaterThan(0);
    }
    
    @Test
    void contextLoads() {
    }
    
}
