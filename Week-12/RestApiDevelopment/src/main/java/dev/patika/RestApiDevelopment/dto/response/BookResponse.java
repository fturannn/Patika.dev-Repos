package dev.patika.RestApiDevelopment.dto.response;

import dev.patika.RestApiDevelopment.entities.Author;
import dev.patika.RestApiDevelopment.entities.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
    private Author author;
    private Publisher publisher;
}
