
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.ProductService;
import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public String home(Model model) {
        Iterable<ProductEntity> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/home"; 
    }
}