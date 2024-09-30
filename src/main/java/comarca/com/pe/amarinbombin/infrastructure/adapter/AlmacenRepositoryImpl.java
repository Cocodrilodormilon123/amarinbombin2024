
package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.AlmacenRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AlmacenRepositoryImpl implements AlmacenRepository {

    private final AlmacenCrudRepository almacenCrudRepository;

    public AlmacenRepositoryImpl(AlmacenCrudRepository almacenCrudRepository) {
        this.almacenCrudRepository = almacenCrudRepository;
    }

    @Override
    public Iterable<AlmacenEntity> getAllAlmacenes() {
        return almacenCrudRepository.findAll();
    }

    @Override
    public AlmacenEntity getAlmacenById(Integer idA) {
        return almacenCrudRepository.findById(idA).orElse(null);
    }

    @Override
    public AlmacenEntity saveAlmacen(AlmacenEntity almacenEntity) {
        return almacenCrudRepository.save(almacenEntity);
    }

    @Override
    public boolean deleteAlmacenById(Integer idA) {
        almacenCrudRepository.deleteById(idA);
        return true;
    }
}