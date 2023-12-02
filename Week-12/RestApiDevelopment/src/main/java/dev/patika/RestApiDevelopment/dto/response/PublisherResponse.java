package dev.patika.RestApiDevelopment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponse {
    private Long id;
    private String name;
    private int establishmentYear;
}
