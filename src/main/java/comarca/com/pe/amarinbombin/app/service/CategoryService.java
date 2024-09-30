package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.CategoryRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryEntity> getAllCategorias() {
        return categoryRepository.getAllCategorias();
    }

    public CategoryEntity getCategoriaById(Integer idCg) {
        return categoryRepository.getCategoriaById(idCg);
    }

    public CategoryEntity saveCategoria(CategoryEntity categoryEntity) {
        return categoryRepository.saveCategoria(categoryEntity);
    }

    public boolean deleteCategoriaById(Integer idCg) {
        return categoryRepository.deleteCategoriaById(idCg);
    }
}