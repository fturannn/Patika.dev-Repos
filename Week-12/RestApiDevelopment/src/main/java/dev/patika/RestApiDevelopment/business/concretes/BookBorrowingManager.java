package dev.patika.RestApiDevelopment.business.concretes;

import dev.patika.RestApiDevelopment.business.abstracts.IBookBorrowingService;
import dev.patika.RestApiDevelopment.dao.BookBorrowingRepo;
import dev.patika.RestApiDevelopment.entities.BookBorrowing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {
    private final BookBorrowingRepo bookBorrowingRepo;

    public BookBorrowingManager(BookBorrowingRepo bookBorrowingRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
    }

    @Override
    public BookBorrowing getById(Long id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public String save(BookBorrowing bookBorrowing) {
        if(this.bookBorrowingRepo.findById(bookBorrowing.getId()).orElseThrow().getBook().getStock() == 0) {
            return "İlgili kitabın stoğu bulunmadığından işlem gerçekleştirilemedi!";
        } else {
            this.bookBorrowingRepo.save(bookBorrowing);
            this.bookBorrowingRepo.findById(bookBorrowing.getId()).orElseThrow().getBook().setStock(
                    this.bookBorrowingRepo.findById(bookBorrowing.getId()).orElseThrow().getBook().getStock() - 1);
            return "İşlem başarılı";
        }
    }

    @Override
    public void delete(Long id) {
        this.bookBorrowingRepo.delete(this.getById(id));
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        if (bookBorrowing.getId() == 0) {
            throw new RuntimeException("Lütfen id değeri olan bir entity giriniz!");
        }
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public List<BookBorrowing> findAll() {
        return this.bookBorrowingRepo.findAll();
    }
}
