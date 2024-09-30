package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.DetallePedidoRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;

public class DetallePedidoService {
    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public Iterable<DetallePedidoEntity> getAllDetallesPedido() {
        return detallePedidoRepository.getAllDetallesPedido();
    }

    public DetallePedidoEntity getDetallePedidoById(Integer idDP) {
        return detallePedidoRepository.getDetallePedidoById(idDP);
    }

    public DetallePedidoEntity saveDetallePedido(DetallePedidoEntity detallePedidoEntity) {
        return detallePedidoRepository.saveDetallePedido(detallePedidoEntity);
    }

    public boolean deleteDetallePedidoById(Integer idDP) {
        return detallePedidoRepository.deleteDetallePedidoById(idDP);
    }
}