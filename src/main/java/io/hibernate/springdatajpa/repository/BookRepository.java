package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
