package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IBookBorrowingService;
import dev.patika.RestApiDevelopment.entities.BookBorrowing;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookBorrowingController {
    private final IBookBorrowingService bookBorrowingService;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }

    @GetMapping("/bookborrowings")
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowing> findAll() {
        return this.bookBorrowingService.findAll();
    }

    @GetMapping("/bookborrowings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing getById(@PathVariable("id") Long id) {
        return this.bookBorrowingService.getById(id);
    }

    @PostMapping("/bookborrowings")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody BookBorrowing bookBorrowing) {
        return this.bookBorrowingService.save(bookBorrowing);
    }

    @DeleteMapping("/bookborrowings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.bookBorrowingService.delete(id);
    }

    @PutMapping("/bookborrowings")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing update(@RequestBody BookBorrowing bookBorrowing) {
        return this.bookBorrowingService.update(bookBorrowing);
    }

}
