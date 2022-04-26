package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.composite.AuthorEmbedded;
import io.hibernate.springdatajpa.entity.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
