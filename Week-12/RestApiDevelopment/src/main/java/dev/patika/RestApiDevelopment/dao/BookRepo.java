package dev.patika.RestApiDevelopment.dao;

import dev.patika.RestApiDevelopment.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
