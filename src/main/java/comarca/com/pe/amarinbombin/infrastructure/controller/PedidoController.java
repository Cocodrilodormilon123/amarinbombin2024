
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.PedidoService;
import comarca.com.pe.amarinbombin.infrastructure.entity.PedidoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/list")
    public String showPedidoList(Model model) {
        model.addAttribute("pedidos", pedidoService.getAllPedidos());
        return "pedido/list";
    }

    @GetMapping("/create")
    public String createPedidoForm(Model model) {
        model.addAttribute("pedido", new PedidoEntity());
        return "pedido/create";
    }

    @PostMapping("/savePedido")
    public String savePedido(PedidoEntity pedidoEntity) {
        pedidoService.savePedido(pedidoEntity);
        return "redirect:/pedidos/list";
    }

    @GetMapping("/edit/{id}")
    public String editPedidoForm(@PathVariable Integer idP, Model model) {
        PedidoEntity pedido = pedidoService.getPedidoById(idP);
        model.addAttribute("pedido", pedido);
        return "pedido/edit";
    }

    @GetMapping("/search")
    public String searchPedidos(@RequestParam("nroPedido") String nroPedido, Model model) {
        model.addAttribute("pedidos", pedidoService.findByNroPedido(nroPedido));
        return "pedido/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePedido(@PathVariable Integer idP) {
        pedidoService.deletePedidoById(idP);
        return "redirect:/pedidos/list";
    }
}