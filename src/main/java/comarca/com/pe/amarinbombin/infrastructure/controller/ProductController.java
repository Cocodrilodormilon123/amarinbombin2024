
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.ProductService;
import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String createProductForm() {
        return "admin/products/create"; // Redirigir a la vista de creación de productos
    }

    @GetMapping("/show")
    public String showProductList(Model model) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdU(1); // Usuario temporal, puedes cambiarlo según sea necesario
        Iterable<ProductEntity> products = productService.getProductsByUser(userEntity);
        model.addAttribute("products", products);
        return "admin/products/show"; // Redirigir a la vista de lista de productos
    }

    @PostMapping("/saveProduct")
    public String saveProduct(ProductEntity product, @RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
        log.info("Guardando producto: {}", product);
        productService.saveProduct(product, multipartFile);
        return "redirect:/admin/products/show"; // Redirigir a la lista de productos después de guardar
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Integer id, Model model) {
        ProductEntity product = productService.getProductById(id);
        log.info("Editando producto: {}", product);
        model.addAttribute("product", product);
        return "admin/products/edit"; // Redirigir a la vista de edición de productos
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/admin/products/show"; // Redirigir a la lista de productos después de eliminar
    }
}
