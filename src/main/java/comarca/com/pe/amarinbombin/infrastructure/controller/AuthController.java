package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.UserService;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login() {
        return "login"; 
    }

    @PostMapping
    public String loginUser(@RequestParam String correo, @RequestParam String contrasena, Model model) {
        UserEntity user = userService.findByCorreoAndContrasena(correo, contrasena);
        
        if (user != null) {
            if ("ADMIN".equals(user.getTypeUser().toString())) {
                return "redirect:/admin"; 
            } else {
                return "redirect:/homeU";
            }
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login"; 
        }
    }
}