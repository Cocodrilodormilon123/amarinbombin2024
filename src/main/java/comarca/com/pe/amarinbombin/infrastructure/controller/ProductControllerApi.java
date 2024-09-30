package comarca.com.pe.amarinbombin.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import comarca.com.pe.amarinbombin.app.service.ProductService;
import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;

@RestController
@RequestMapping("/api/products")
public class ProductControllerApi {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductControllerApi.class);

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }

    // Obtener todos los productos
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<ProductEntity> listProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestPart("product") String productJson, @RequestPart("multipartFile") MultipartFile multipartFile) throws IOException {
        // Convertir el JSON a un objeto ProductEntity
        ObjectMapper objectMapper = new ObjectMapper();
        ProductEntity product = objectMapper.readValue(productJson, ProductEntity.class);
        return productService.saveProduct(product, multipartFile);
    }

    // Obtener producto por ID
    @GetMapping("/get/{id}")
    public ProductEntity getProductById(@PathVariable Integer idPr) {
        return productService.getProductById(idPr);
    }

    // Actualizar producto existente
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity updateProduct(@RequestBody ProductEntity product, @PathVariable Integer idPr, MultipartFile multipartFile) throws IOException {
        ProductEntity productActual = productService.getProductById(idPr);
        productActual.setDescripcion(product.getDescripcion());
        productActual.setNombre(product.getNombre());
        productActual.setPrecio(product.getPrecio());
        productActual.setUserEntity(product.getUserEntity());
        return productService.saveProduct(productActual, multipartFile);
    }

    // Eliminar producto
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable Integer idPr) {
        return productService.deleteProductById(idPr);
    }
}
