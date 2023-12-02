package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Author;

import java.util.List;

public interface IAuthorService {
    Author getById(Long id);
    Author save(Author author);
    void delete(Long id);
    Author update(Author author);
    List<Author> findAll();
}
