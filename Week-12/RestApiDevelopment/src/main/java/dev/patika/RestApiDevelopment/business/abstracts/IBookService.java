package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Author;
import dev.patika.RestApiDevelopment.entities.Book;

import java.util.List;

public interface IBookService {
    Book getById(int id);
    Book save(Book book);
    void delete(int id);
    Book update(Book book);
    List<Book> findAll();
}
