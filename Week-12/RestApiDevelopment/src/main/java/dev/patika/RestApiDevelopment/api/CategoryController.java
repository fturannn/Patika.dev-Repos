package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.ICategoryService;
import dev.patika.RestApiDevelopment.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getById(@PathVariable("id") Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.categoryService.delete(id);
    }

    @PutMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category) {
        return this.categoryService.save(category);
    }
}
