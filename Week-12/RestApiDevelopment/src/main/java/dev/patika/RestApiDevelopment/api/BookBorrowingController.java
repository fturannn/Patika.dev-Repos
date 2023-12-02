package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IBookBorrowingService;
import dev.patika.RestApiDevelopment.dto.request.BookBorrowingUpdateRequest;
import dev.patika.RestApiDevelopment.dto.response.BookBorrowingResponse;
import dev.patika.RestApiDevelopment.entities.BookBorrowing;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class BookBorrowingController {
    private final IBookBorrowingService bookBorrowingService;
    private final ModelMapper modelMapper;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService, ModelMapper modelMapper) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/bookborrowings")
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowingResponse> findAll() {
        List <BookBorrowing> bookBorrowingList = this.bookBorrowingService.findAll();
        List <BookBorrowingResponse> bookBorrowingResponseList = bookBorrowingList.stream().map(
                bookBorrowing -> this.modelMapper.map(bookBorrowing, BookBorrowingResponse.class)).collect(Collectors.toList());
        return bookBorrowingResponseList;
    }

    @GetMapping("/bookborrowings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowingResponse getById(@PathVariable("id") Long id) {
        BookBorrowingResponse bookBorrowingResponse = this.modelMapper.map(this.bookBorrowingService.getById(id), BookBorrowingResponse.class);
        return bookBorrowingResponse;
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
    public String update(@RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest) {
        BookBorrowing updatedBookBorrowing = this.bookBorrowingService.getById(bookBorrowingUpdateRequest.getId());
        updatedBookBorrowing.setBorrowerName(bookBorrowingUpdateRequest.getBorrowerName());
        updatedBookBorrowing.setBorrowingDate(bookBorrowingUpdateRequest.getBorrowingDate());
        updatedBookBorrowing.setReturnDate(bookBorrowingUpdateRequest.getReturnDate());
        return this.bookBorrowingService.save(updatedBookBorrowing);
    }

}
