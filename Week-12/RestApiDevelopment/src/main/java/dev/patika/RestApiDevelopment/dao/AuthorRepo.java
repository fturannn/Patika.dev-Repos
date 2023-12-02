package dev.patika.RestApiDevelopment.dao;

import dev.patika.RestApiDevelopment.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
