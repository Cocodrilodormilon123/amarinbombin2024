
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.CategoryService;
import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllerApi {

    private final CategoryService categoryService;

    public CategoryControllerApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public Iterable<CategoryEntity> listCategories() {
        return categoryService.getAllCategorias();
    }

    @GetMapping("/get/{id}")
    public CategoryEntity getCategoryById(@PathVariable Integer idCg) {
        return categoryService.getCategoriaById(idCg);
    }

    @PostMapping("/create")
    public CategoryEntity createCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.saveCategoria(categoryEntity);
    }

    @PutMapping("/update/{id}")
    public CategoryEntity updateCategory(@PathVariable Integer idCg, @RequestBody CategoryEntity categoryEntity) {
        categoryEntity.setIdCg(idCg);
        return categoryService.saveCategoria(categoryEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable Integer idCg) {
        return categoryService.deleteCategoriaById(idCg);
    }
}