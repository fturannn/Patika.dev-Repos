package dev.patika.RestApiDevelopment.business.concretes;

import dev.patika.RestApiDevelopment.business.abstracts.ICategoryService;
import dev.patika.RestApiDevelopment.dao.CategoryRepo;
import dev.patika.RestApiDevelopment.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getById(Long id) {
        return this.categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public String delete(Long id) {
        if (this.getById(id).getBookList().isEmpty()) {
            this.categoryRepo.delete(this.getById(id));
            return "İşlem başarılı!";
        } else {
            return "Sistemde bu kategoriye ait kayıtlı kitaplar var. Bu kategori silinemedi!";
        }
    }

    @Override
    public Category update(Category category) {
        if (category.getId() == 0) {
            throw new RuntimeException("Lütfen id değeri olan bir entity giriniz!");
        }
        return this.categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
