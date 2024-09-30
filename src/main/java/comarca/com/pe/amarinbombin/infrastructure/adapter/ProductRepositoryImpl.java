
package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.ProductRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return productCrudRepository.findAll();
    }
    
    @Override
    public Iterable<ProductEntity> getProductsByUser(UserEntity userEntity) {
        return productCrudRepository.findByUserEntity(userEntity);
    }

    @Override
    public ProductEntity getProductById(Integer idPr) {
        return productCrudRepository.findById(idPr).orElse(null);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productCrudRepository.save(productEntity);
    }

    @Override
    public boolean deleteProductById(Integer idPr) {
        productCrudRepository.deleteById(idPr);
        return true;
    }

    @Override
    public Iterable<ProductEntity> findByCategoriaIdCg(Integer idCg) {
        return productCrudRepository.findByCategoriaIdCg(idCg);
    }
}