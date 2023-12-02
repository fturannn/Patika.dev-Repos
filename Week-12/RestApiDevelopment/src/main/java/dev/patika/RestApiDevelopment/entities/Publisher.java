package dev.patika.RestApiDevelopment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

    @Column(name = "publisher_est_year", nullable = false)
    private int establishmentYear;

    @Column(name = "publisher_address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;
}
