package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;

public interface PedidoRepository {
    Iterable<PedidoEntity> getAllPedidos();
    PedidoEntity getPedidoById(Integer idP);
    PedidoEntity savePedido(PedidoEntity pedidoEntity);
    boolean deletePedidoById(Integer idP);
    Iterable<PedidoEntity> findByNroPedido(String nroPedido);
}