
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.CategoryService;
import comarca.com.pe.amarinbombin.app.service.ProductService;
import comarca.com.pe.amarinbombin.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CategoryService categoryService;


    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/") 
    public String home(Model model) {
        Iterable<CategoryEntity> categories = categoryService.getAllCategorias();
        model.addAttribute("categories", categories);
        return "index"; 
    }

}