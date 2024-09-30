
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.AlmacenService;
import comarca.com.pe.amarinbombin.infrastructure.entity.AlmacenEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/almacenes")
public class AlmacenController {

    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping("/list")
    public String showAlmacenList(Model model) {
        model.addAttribute("almacenes", almacenService.getAllAlmacenes());
        return "almacen/list";
    }

    @GetMapping("/create")
    public String createAlmacenForm(Model model) {
        model.addAttribute("almacen", new AlmacenEntity());
        return "almacen/create";
    }

    @PostMapping("/saveAlmacen")
    public String saveAlmacen(AlmacenEntity almacenEntity) {
        almacenService.saveAlmacen(almacenEntity);
        return "redirect:/almacenes/list";
    }

    @GetMapping("/edit/{id}")
    public String editAlmacenForm(@PathVariable Integer idA, Model model) {
        AlmacenEntity almacen = almacenService.getAlmacenById(idA);
        model.addAttribute("almacen", almacen);
        return "almacen/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlmacen(@PathVariable Integer idA) {
        almacenService.deleteAlmacenById(idA);
        return "redirect:/almacenes/list";
    }
}
