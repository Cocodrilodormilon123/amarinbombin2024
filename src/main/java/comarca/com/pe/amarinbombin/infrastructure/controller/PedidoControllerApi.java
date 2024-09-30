
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.PedidoService;
import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControllerApi {

    private final PedidoService pedidoService;

    public PedidoControllerApi(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/list")
    public Iterable<PedidoEntity> listPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/get/{id}")
    public PedidoEntity getPedidoById(@PathVariable Integer idP) {
        return pedidoService.getPedidoById(idP);
    }

    @GetMapping("/search/{nroPedido}")
    public Iterable<PedidoEntity> getPedidosByNroPedido(@PathVariable String nroPedido) {
        return pedidoService.findByNroPedido(nroPedido);
    }

    @PostMapping("/create")
    public PedidoEntity createPedido(@RequestBody PedidoEntity pedidoEntity) {
        return pedidoService.savePedido(pedidoEntity);
    }

    @PutMapping("/update/{id}")
    public PedidoEntity updatePedido(@PathVariable Integer idP, @RequestBody PedidoEntity pedidoEntity) {
        pedidoEntity.setIdP(idP);
        return pedidoService.savePedido(pedidoEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePedido(@PathVariable Integer idP) {
        return pedidoService.deletePedidoById(idP);
    }
}