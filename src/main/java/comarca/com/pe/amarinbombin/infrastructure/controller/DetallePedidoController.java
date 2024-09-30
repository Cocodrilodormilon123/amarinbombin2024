
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.DetallePedidoService;
import comarca.com.pe.amarinbombin.infrastructure.entity.DetallePedidoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detallepedidos")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping("/list")
    public String showDetallePedidoList(Model model) {
        model.addAttribute("detallepedidos", detallePedidoService.getAllDetallesPedido());
        return "detallepedido/list";
    }

    @GetMapping("/create")
    public String createDetallePedidoForm(Model model) {
        model.addAttribute("detallepedido", new DetallePedidoEntity());
        return "detallepedido/create";
    }

    @PostMapping("/saveDetallePedido")
    public String saveDetallePedido(DetallePedidoEntity detallePedidoEntity) {
        detallePedidoService.saveDetallePedido(detallePedidoEntity);
        return "redirect:/detallepedidos/list";
    }

    @GetMapping("/edit/{id}")
    public String editDetallePedidoForm(@PathVariable Integer idDP, Model model) {
        DetallePedidoEntity detallePedido = detallePedidoService.getDetallePedidoById(idDP);
        model.addAttribute("detallepedido", detallePedido);
        return "detallepedido/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteDetallePedido(@PathVariable Integer idDP) {
        detallePedidoService.deleteDetallePedidoById(idDP);
        return "redirect:/detallepedidos/list";
    }
}