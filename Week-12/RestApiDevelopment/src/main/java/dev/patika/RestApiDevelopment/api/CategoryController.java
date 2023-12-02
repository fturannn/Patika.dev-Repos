package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.ICategoryService;
import dev.patika.RestApiDevelopment.dto.response.CategoryResponse;
import dev.patika.RestApiDevelopment.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CategoryController {

    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(ICategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> findAll() {
        List <Category> categoryList = this.categoryService.findAll();
        List <CategoryResponse> categoryResponseList = categoryList.stream().map(
                category -> this.modelMapper.map(category, CategoryResponse.class)).collect(Collectors.toList());
        return categoryResponseList;
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getById(@PathVariable("id") Long id) {
        CategoryResponse categoryResponse = this.modelMapper.map(this.categoryService.getById(id), CategoryResponse.class);
        return categoryResponse;
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
