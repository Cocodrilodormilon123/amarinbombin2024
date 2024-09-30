
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.TransaccionService;
import comarca.com.pe.amarinbombin.infrastructure.entity.TransaccionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping("/list")
    public String showTransaccionList(Model model) {
        model.addAttribute("transacciones", transaccionService.getAllTransacciones());
        return "transaccion/list";
    }

    @GetMapping("/create")
    public String createTransaccionForm(Model model) {
        model.addAttribute("transaccion", new TransaccionEntity());
        return "transaccion/create";
    }

    @PostMapping("/saveTransaccion")
    public String saveTransaccion(TransaccionEntity transaccionEntity) {
        transaccionService.saveTransaccion(transaccionEntity);
        return "redirect:/transacciones/list";
    }

    @GetMapping("/edit/{id}")
    public String editTransaccionForm(@PathVariable Integer idT, Model model) {
        TransaccionEntity transaccion = transaccionService.getTransaccionById(idT);
        model.addAttribute("transaccion", transaccion);
        return "transaccion/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaccion(@PathVariable Integer idT) {
        transaccionService.deleteTransaccionById(idT);
        return "redirect:/transacciones/list";
    }
}