package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.TransaccionRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.TransaccionEntity;

public class TransaccionService {
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Iterable<TransaccionEntity> getAllTransacciones() {
        return transaccionRepository.getAllTransacciones();
    }

    public TransaccionEntity getTransaccionById(Integer idT) {
        return transaccionRepository.getTransaccionById(idT);
    }

    public TransaccionEntity saveTransaccion(TransaccionEntity transaccionEntity) {
        return transaccionRepository.saveTransaccion(transaccionEntity);
    }

    public boolean deleteTransaccionById(Integer idT) {
        return transaccionRepository.deleteTransaccionById(idT);
    }
}