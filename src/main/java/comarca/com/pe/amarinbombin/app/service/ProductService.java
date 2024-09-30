package comarca.com.pe.amarinbombin.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import comarca.com.pe.amarinbombin.app.repository.ProductRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;

public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity userEntity) {
        return productRepository.getProductsByUser(userEntity);
    }

    public ProductEntity getProductById(Integer idPr) {
        return productRepository.getProductById(idPr);
    }

    public ProductEntity saveProduct(ProductEntity productEntity, MultipartFile multipartfile) throws IOException {
        if (productEntity.getIdPr() == null) {
            // Crear nuevo producto
            UserEntity user = new UserEntity();
            user.setIdU(1); // Asignación temporal de usuario
            productEntity.setDateCreated(LocalDateTime.now());
            productEntity.setDateUpdated(LocalDateTime.now());
            productEntity.setUserEntity(user);

            // Manejo de archivo
            if (multipartfile != null && !multipartfile.isEmpty()) {
                productEntity.setImagen(uploadFile.upload(multipartfile));
            } else {
                productEntity.setImagen("default.jpg");
            }
            return productRepository.saveProduct(productEntity);
        } else {
            // Actualizar producto existente
            ProductEntity productDB = productRepository.getProductById(productEntity.getIdPr());

            if (multipartfile != null && !multipartfile.isEmpty()) {
                if (!productDB.getImagen().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImagen());
                }
                productEntity.setImagen(uploadFile.upload(multipartfile));
            } else {
                productEntity.setImagen(productDB.getImagen());
            }

            productEntity.setDateCreated(productDB.getDateCreated());
            productEntity.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }

    public boolean deleteProductById(Integer idPr) {
        return productRepository.deleteProductById(idPr);
    }
    public Iterable<ProductEntity> getProductsByCategory(Integer idCg) {
        return productRepository.findByCategoriaIdCg(idCg);
    }
}