package dev.patika.RestApiDevelopment.business.concretes;

import dev.patika.RestApiDevelopment.business.abstracts.IPublisherService;
import dev.patika.RestApiDevelopment.dao.PublisherRepo;
import dev.patika.RestApiDevelopment.entities.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher getById(Long id) {
        return this.publisherRepo.findById(id).orElseThrow();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public String delete(Long id) {
        if (this.getById(id).getBookList().isEmpty()) {
            this.publisherRepo.delete(this.getById(id));
            return "İşlem başarılı!";
        } else {
            return "Sistemde yayıncıya ait kitaplar var. Bu yayıncı silinemedi!";
        }
    }

    @Override
    public Publisher update(Publisher publisher) {
        if (publisher.getId() == 0) {
            throw new RuntimeException("Lütfen id değeri olan bir entity giriniz!");
        }
        return this.publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepo.findAll();
    }
}
