package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.TransaccionEntity;

public interface TransaccionRepository {
    Iterable<TransaccionEntity> getAllTransacciones();
    TransaccionEntity getTransaccionById(Integer idT);
    TransaccionEntity saveTransaccion(TransaccionEntity transaccionEntity);
    boolean deleteTransaccionById(Integer idT);
}