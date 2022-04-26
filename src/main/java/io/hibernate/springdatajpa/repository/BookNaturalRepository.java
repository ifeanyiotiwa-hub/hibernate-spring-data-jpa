package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
