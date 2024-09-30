package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;

public interface DetallePedidoRepository {
    Iterable<DetallePedidoEntity> getAllDetallesPedido();
    DetallePedidoEntity getDetallePedidoById(Integer idDP);
    DetallePedidoEntity saveDetallePedido(DetallePedidoEntity detallePedidoEntity);
    boolean deleteDetallePedidoById(Integer idDP);
}