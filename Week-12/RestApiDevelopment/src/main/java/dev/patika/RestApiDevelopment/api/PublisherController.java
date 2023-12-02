package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IPublisherService;
import dev.patika.RestApiDevelopment.entities.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PublisherController {

    private final IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> findAll() {
        return this.publisherService.findAll();
    }

    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getById(@PathVariable("id") Long id) {
        return this.publisherService.getById(id);
    }

    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher) {
        return this.publisherService.save(publisher);
    }

    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  String delete(@PathVariable("id") Long id) {
        return this.publisherService.delete(id);
    }

    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher) {
        return this.publisherService.save(publisher);
    }
}
