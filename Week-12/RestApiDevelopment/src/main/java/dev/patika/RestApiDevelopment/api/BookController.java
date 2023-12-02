package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IBookService;
import dev.patika.RestApiDevelopment.dto.response.BookResponse;
import dev.patika.RestApiDevelopment.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class BookController {
    private final IBookService bookService;
    private final ModelMapper modelMapper;
    public BookController(IBookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findAll() {
        List <Book> bookList = this.bookService.findAll();
        List <BookResponse> bookResponseList = bookList.stream().map(
                book -> this.modelMapper.map(book, BookResponse.class)).collect(Collectors.toList());
        return bookResponseList;
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getById(@PathVariable("id") Long id) {
        BookResponse bookResponse = this.modelMapper.map(this.bookService.getById(id), BookResponse.class);
        return bookResponse;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return this.bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book) {
        return this.bookService.update(book);
    }
}
