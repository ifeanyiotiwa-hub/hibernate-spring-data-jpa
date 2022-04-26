package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.composite.AuthorComposite;
import io.hibernate.springdatajpa.entity.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
