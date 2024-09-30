package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoCrudRepository extends CrudRepository<DetallePedidoEntity, Integer> {
}