
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.AlmacenService;
import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenControllerApi {

    private final AlmacenService almacenService;

    public AlmacenControllerApi(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping("/list")
    public Iterable<AlmacenEntity> listAlmacenes() {
        return almacenService.getAllAlmacenes();
    }

    @GetMapping("/get/{id}")
    public AlmacenEntity getAlmacenById(@PathVariable Integer idA) {
        return almacenService.getAlmacenById(idA);
    }

    @PostMapping("/create")
    public AlmacenEntity createAlmacen(@RequestBody AlmacenEntity almacenEntity) {
        return almacenService.saveAlmacen(almacenEntity);
    }

    @PutMapping("/update/{id}")
    public AlmacenEntity updateAlmacen(@PathVariable Integer idA, @RequestBody AlmacenEntity almacenEntity) {
        almacenEntity.setIdA(idA);
        return almacenService.saveAlmacen(almacenEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAlmacen(@PathVariable Integer idA) {
        return almacenService.deleteAlmacenById(idA);
    }
}
