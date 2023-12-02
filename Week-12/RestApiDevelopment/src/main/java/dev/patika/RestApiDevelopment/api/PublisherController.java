package dev.patika.RestApiDevelopment.api;

import dev.patika.RestApiDevelopment.business.abstracts.IPublisherService;
import dev.patika.RestApiDevelopment.dto.response.PublisherResponse;
import dev.patika.RestApiDevelopment.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class PublisherController {

    private final IPublisherService publisherService;
    private final ModelMapper modelMapper;

    public PublisherController(IPublisherService publisherService, ModelMapper modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherResponse> findAll() {
        List <Publisher> publisherList = this.publisherService.findAll();
        List <PublisherResponse> publisherResponseList = publisherList.stream().map(
                publisher -> this.modelMapper.map(publisher, PublisherResponse.class)).collect(Collectors.toList());
        return publisherResponseList;
    }

    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponse getById(@PathVariable("id") Long id) {
        PublisherResponse publisherResponse = this.modelMapper.map(this.publisherService.getById(id), PublisherResponse.class);
        return publisherResponse;
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
