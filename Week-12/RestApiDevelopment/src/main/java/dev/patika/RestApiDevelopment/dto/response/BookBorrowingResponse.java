package dev.patika.RestApiDevelopment.dto.response;

import dev.patika.RestApiDevelopment.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingResponse {
    private Long id;
    private String borrowerName;
    private String borrowerEmail;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private Book book;
}
