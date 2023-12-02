package dev.patika.RestApiDevelopment.business.concretes;

import dev.patika.RestApiDevelopment.business.abstracts.IAuthorService;
import dev.patika.RestApiDevelopment.dao.AuthorRepo;
import dev.patika.RestApiDevelopment.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements IAuthorService {
    private final AuthorRepo authorRepo;

    public AuthorManager(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepo.findById(id).orElseThrow();
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public void delete(Long id) {
        this.authorRepo.delete(this.getById(id));
    }

    @Override
    public Author update(Author author) {
        if (author.getId() == 0) {
            throw new RuntimeException("Lütfen id değeri olan bir entity giriniz!");
        }
        return this.authorRepo.save(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepo.findAll();
    }
}
