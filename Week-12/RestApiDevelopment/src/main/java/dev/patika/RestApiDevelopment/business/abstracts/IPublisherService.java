package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher getById(Long id);
    Publisher save(Publisher publisher);
    String delete(Long id);
    Publisher update(Publisher publisher);
    List<Publisher> findAll();
}
