
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.CategoryService;
import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String showCategoryList(Model model) {
        model.addAttribute("categories", categoryService.getAllCategorias());
        return "category/list";
    }

    @GetMapping("/create")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "category/create";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(CategoryEntity categoryEntity) {
        categoryService.saveCategoria(categoryEntity);
        return "redirect:/categories/list";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Integer idCg, Model model) {
        CategoryEntity category = categoryService.getCategoriaById(idCg);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer idCg) {
        categoryService.deleteCategoriaById(idCg);
        return "redirect:/categories/list";
    }
}