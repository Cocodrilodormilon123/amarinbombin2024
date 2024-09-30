
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.DetallePedidoService;
import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detallepedidos")
public class DetallePedidoControllerApi {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoControllerApi(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping("/list")
    public Iterable<DetallePedidoEntity> listDetallePedidos() {
        return detallePedidoService.getAllDetallesPedido();
    }

    @GetMapping("/get/{id}")
    public DetallePedidoEntity getDetallePedidoById(@PathVariable Integer idDP) {
        return detallePedidoService.getDetallePedidoById(idDP);
    }

    @PostMapping("/create")
    public DetallePedidoEntity createDetallePedido(@RequestBody DetallePedidoEntity detallePedidoEntity) {
        return detallePedidoService.saveDetallePedido(detallePedidoEntity);
    }

    @PutMapping("/update/{id}")
    public DetallePedidoEntity updateDetallePedido(@PathVariable Integer idDP, @RequestBody DetallePedidoEntity detallePedidoEntity) {
        detallePedidoEntity.setIdDP(idDP);
        return detallePedidoService.saveDetallePedido(detallePedidoEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDetallePedido(@PathVariable Integer idDP) {
        return detallePedidoService.deleteDetallePedidoById(idDP);
    }
}