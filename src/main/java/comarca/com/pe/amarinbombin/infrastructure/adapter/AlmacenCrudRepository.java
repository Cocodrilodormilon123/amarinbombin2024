package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenCrudRepository extends CrudRepository<AlmacenEntity, Integer> {
}
