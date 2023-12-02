package dev.patika.RestApiDevelopment.business.abstracts;

import dev.patika.RestApiDevelopment.entities.Category;
import java.util.List;

public interface ICategoryService {

    Category getById(Long id);
    Category save(Category category);
    String delete(Long id);
    Category update(Category category);
    List<Category> findAll();
}
