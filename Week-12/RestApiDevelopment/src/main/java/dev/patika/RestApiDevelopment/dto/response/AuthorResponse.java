package dev.patika.RestApiDevelopment.dto.response;

import dev.patika.RestApiDevelopment.entities.Author;
import dev.patika.RestApiDevelopment.entities.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;
}
