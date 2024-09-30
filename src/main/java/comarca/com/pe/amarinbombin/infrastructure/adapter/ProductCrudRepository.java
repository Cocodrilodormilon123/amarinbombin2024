package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.infrastructure.entity.ProductEntity;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByCategoriaIdCg(Integer idCg);
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
}
