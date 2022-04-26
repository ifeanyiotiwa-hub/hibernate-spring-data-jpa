package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
