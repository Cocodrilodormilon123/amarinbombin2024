
package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.CategoryRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryCrudRepository categoryCrudRepository;

    public CategoryRepositoryImpl(CategoryCrudRepository categoryCrudRepository) {
        this.categoryCrudRepository = categoryCrudRepository;
    }

    @Override
    public Iterable<CategoryEntity> getAllCategorias() {
        return categoryCrudRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoriaById(Integer idCg) {
        return categoryCrudRepository.findById(idCg).orElse(null);
    }

    @Override
    public CategoryEntity saveCategoria(CategoryEntity categoryEntity) {
        return categoryCrudRepository.save(categoryEntity);
    }

    @Override
    public boolean deleteCategoriaById(Integer idCg) {
        categoryCrudRepository.deleteById(idCg);
        return true;
    }
}