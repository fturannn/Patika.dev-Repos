package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Book;

import java.util.List;

public interface IBookService {
    Book getById(Long id);
    Book save(Book book);
    void delete(Long id);
    Book update(Book book);
    List<Book> findAll();
}
