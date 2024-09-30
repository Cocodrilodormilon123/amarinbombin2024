package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;

public interface CategoryRepository {
    Iterable<CategoryEntity> getAllCategorias();
    CategoryEntity getCategoriaById(Integer idCg);
    CategoryEntity saveCategoria(CategoryEntity categoryEntity);
    boolean deleteCategoriaById(Integer idCg);
}