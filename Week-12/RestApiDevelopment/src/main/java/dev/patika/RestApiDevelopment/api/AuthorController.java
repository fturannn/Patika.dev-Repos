package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IAuthorService;
import dev.patika.RestApiDevelopment.dto.response.AuthorResponse;
import dev.patika.RestApiDevelopment.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class AuthorController {
    private final IAuthorService authorService;
    private final ModelMapper modelMapper;

    public AuthorController(IAuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> findAll() {
        List <Author> authorList = this.authorService.findAll();
        List <AuthorResponse> authorResponseList = authorList.stream().map(
                author -> this.modelMapper.map(author, AuthorResponse.class)).collect(Collectors.toList());
        return authorResponseList;
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getById(@PathVariable("id") Long id) {
        AuthorResponse authorResponse = this.modelMapper.map(this.authorService.getById(id), AuthorResponse.class);
        return authorResponse;
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
