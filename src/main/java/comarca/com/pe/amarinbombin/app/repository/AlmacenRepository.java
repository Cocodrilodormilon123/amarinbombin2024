package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;

public interface AlmacenRepository {
    Iterable<AlmacenEntity> getAllAlmacenes();
    AlmacenEntity getAlmacenById(Integer idA);
    AlmacenEntity saveAlmacen(AlmacenEntity almacenEntity);
    boolean deleteAlmacenById(Integer idA);
}