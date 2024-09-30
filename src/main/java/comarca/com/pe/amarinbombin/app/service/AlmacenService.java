package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.AlmacenRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;

public class AlmacenService {
    private final AlmacenRepository almacenRepository;

    public AlmacenService(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }

    public Iterable<AlmacenEntity> getAllAlmacenes() {
        return almacenRepository.getAllAlmacenes();
    }

    public AlmacenEntity getAlmacenById(Integer idA) {
        return almacenRepository.getAlmacenById(idA);
    }

    public AlmacenEntity saveAlmacen(AlmacenEntity almacenEntity) {
        return almacenRepository.saveAlmacen(almacenEntity);
    }

    public boolean deleteAlmacenById(Integer idA) {
        return almacenRepository.deleteAlmacenById(idA);
    }
}