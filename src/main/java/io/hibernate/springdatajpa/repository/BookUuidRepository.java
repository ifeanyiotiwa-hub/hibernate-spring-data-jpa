package io.hibernate.springdatajpa.repository;

import io.hibernate.springdatajpa.entity.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
