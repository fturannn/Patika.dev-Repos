package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IAuthorService;
import dev.patika.RestApiDevelopment.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getById(@PathVariable("id") Long id) {
        return this.authorService.getById(id);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) {
        return this.authorService.save(author);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.authorService.delete(id);
    }

    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@RequestBody Author author) {
        return this.authorService.update(author);
    }

}
