package dev.patika.RestApiDevelopment.dao;

import dev.patika.RestApiDevelopment.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
}
