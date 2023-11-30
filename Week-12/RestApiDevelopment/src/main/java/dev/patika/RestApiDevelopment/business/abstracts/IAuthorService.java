package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Author;

import java.util.List;

public interface IAuthorService {
    Author getById(int id);
    Author save(Author author);
    void delete(int id);
    Author update(Author author);
    List<Author> findAll();
}
