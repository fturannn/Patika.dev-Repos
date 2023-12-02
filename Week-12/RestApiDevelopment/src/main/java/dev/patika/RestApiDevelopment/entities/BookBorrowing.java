package dev.patika.RestApiDevelopment.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookBorrowings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookBorrowing_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "bookBorrowing_borrower_name", nullable = false)
    private String borrowerName;

    @Column(name = "bookBorrowing_borrower_email", nullable = false)
    @Email
    private String borrowerEmail;

    @Temporal(TemporalType.DATE)
    @Column(name = "bookBorrowing_borrowing_date", nullable = false)
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "bookBorrowing_return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bookBorrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
