
package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.PedidoRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Iterable<PedidoEntity> getAllPedidos() {
        return pedidoRepository.getAllPedidos();
    }

    public PedidoEntity getPedidoById(Integer idP) {
        return pedidoRepository.getPedidoById(idP);
    }

    public PedidoEntity savePedido(PedidoEntity pedidoEntity) {
        return pedidoRepository.savePedido(pedidoEntity);
    }

    public boolean deletePedidoById(Integer idP) {
        return pedidoRepository.deletePedidoById(idP);
    }

    public Iterable<PedidoEntity> findByNroPedido(String nroPedido) {
        return pedidoRepository.findByNroPedido(nroPedido);
    }
}