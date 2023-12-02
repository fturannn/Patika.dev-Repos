package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.BookBorrowing;
import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getById(Long id);
    String save(BookBorrowing bookBorrowing);
    void delete(Long id);
    String update(BookBorrowing bookBorrowing);
    List<BookBorrowing> findAll();
}
