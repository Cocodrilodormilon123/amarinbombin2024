
package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.DetallePedidoRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DetallePedidoRepositoryImpl implements DetallePedidoRepository {

    private final DetallePedidoCrudRepository detallePedidoCrudRepository;

    public DetallePedidoRepositoryImpl(DetallePedidoCrudRepository detallePedidoCrudRepository) {
        this.detallePedidoCrudRepository = detallePedidoCrudRepository;
    }

    @Override
    public Iterable<DetallePedidoEntity> getAllDetallesPedido() {
        return detallePedidoCrudRepository.findAll();
    }

    @Override
    public DetallePedidoEntity getDetallePedidoById(Integer idDP) {
        return detallePedidoCrudRepository.findById(idDP).orElse(null);
    }

    @Override
    public DetallePedidoEntity saveDetallePedido(DetallePedidoEntity detallePedidoEntity) {
        return detallePedidoCrudRepository.save(detallePedidoEntity);
    }

    @Override
    public boolean deleteDetallePedidoById(Integer idDP) {
        detallePedidoCrudRepository.deleteById(idDP);
        return true;
    }
}
