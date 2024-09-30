package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;

public interface ProductRepository {
    Iterable<ProductEntity> getAllProducts();
    Iterable<ProductEntity> getProductsByUser(UserEntity userEntity);
    ProductEntity getProductById(Integer idPr);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer idPr);
    Iterable<ProductEntity> findByCategoriaIdCg(Integer idCg);
}