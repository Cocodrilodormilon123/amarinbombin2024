package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoCrudRepository extends CrudRepository<PedidoEntity, Integer> {
    List<PedidoEntity> findByNroPedido(String nroPedido);
}