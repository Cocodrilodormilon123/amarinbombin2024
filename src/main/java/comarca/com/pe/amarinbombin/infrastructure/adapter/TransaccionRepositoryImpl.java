
package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.TransaccionRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.TransaccionEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TransaccionRepositoryImpl implements TransaccionRepository {

    private final TransaccionCrudRepository transaccionCrudRepository;

    public TransaccionRepositoryImpl(TransaccionCrudRepository transaccionCrudRepository) {
        this.transaccionCrudRepository = transaccionCrudRepository;
    }

    @Override
    public Iterable<TransaccionEntity> getAllTransacciones() {
        return transaccionCrudRepository.findAll();
    }

    @Override
    public TransaccionEntity getTransaccionById(Integer idT) {
        return transaccionCrudRepository.findById(idT).orElse(null);
    }

    @Override
    public TransaccionEntity saveTransaccion(TransaccionEntity transaccionEntity) {
        return transaccionCrudRepository.save(transaccionEntity);
    }

    @Override
    public boolean deleteTransaccionById(Integer idT) {
        transaccionCrudRepository.deleteById(idT);
        return true;
    }
}