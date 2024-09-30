
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.TransaccionService;
import comarca.com.pe.amarinbombin.infrastructure.entity.TransaccionEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionControllerApi {

    private final TransaccionService transaccionService;

    public TransaccionControllerApi(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping("/list")
    public Iterable<TransaccionEntity> listTransacciones() {
        return transaccionService.getAllTransacciones();
    }

    @GetMapping("/get/{id}")
    public TransaccionEntity getTransaccionById(@PathVariable Integer idT) {
        return transaccionService.getTransaccionById(idT);
    }

    @PostMapping("/create")
    public TransaccionEntity createTransaccion(@RequestBody TransaccionEntity transaccionEntity) {
        return transaccionService.saveTransaccion(transaccionEntity);
    }

    @PutMapping("/update/{id}")
    public TransaccionEntity updateTransaccion(@PathVariable Integer idT, @RequestBody TransaccionEntity transaccionEntity) {
        transaccionEntity.setIdT(idT);
        return transaccionService.saveTransaccion(transaccionEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteTransaccion(@PathVariable Integer idT) {
        return transaccionService.deleteTransaccionById(idT);
    }
}
