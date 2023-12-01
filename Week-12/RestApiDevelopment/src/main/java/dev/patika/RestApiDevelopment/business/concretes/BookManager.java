package dev.patika.RestApiDevelopment.business.concretes;

import dev.patika.RestApiDevelopment.business.abstracts.IBookService;
import dev.patika.RestApiDevelopment.dao.BookRepo;
import dev.patika.RestApiDevelopment.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book getById(int id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
        this.bookRepo.delete(this.getById(id));
    }

    @Override
    public Book update(Book book) {
        if (book.getId() == 0) {
            throw new RuntimeException("Lütfen id değeri olan bir entity giriniz!");
        }
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }
}
