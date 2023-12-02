package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Author;
import java.util.List;

public interface IAuthorService {
    Author getById(Long id);
    Author save(Author author);
    String delete(Long id);
    Author update(Author author);
    List<Author> findAll();
}
