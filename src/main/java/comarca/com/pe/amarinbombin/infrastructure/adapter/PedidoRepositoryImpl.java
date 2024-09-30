
package comarca.com.pe.amarinbombin.infrastructure.adapter;


import comarca.com.pe.amarinbombin.app.repository.PedidoRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoCrudRepository pedidoCrudRepository;

    public PedidoRepositoryImpl(PedidoCrudRepository pedidoCrudRepository) {
        this.pedidoCrudRepository = pedidoCrudRepository;
    }

    @Override
    public Iterable<PedidoEntity> getAllPedidos() {
        return pedidoCrudRepository.findAll();
    }

    @Override
    public PedidoEntity getPedidoById(Integer idP) {
        return pedidoCrudRepository.findById(idP).orElse(null);
    }

    @Override
    public PedidoEntity savePedido(PedidoEntity pedidoEntity) {
        return pedidoCrudRepository.save(pedidoEntity);
    }

    @Override
    public boolean deletePedidoById(Integer idP) {
        pedidoCrudRepository.deleteById(idP);
        return true;
    }

    @Override
    public Iterable<PedidoEntity> findByNroPedido(String nroPedido) {
        return pedidoCrudRepository.findByNroPedido(nroPedido);
    }
}