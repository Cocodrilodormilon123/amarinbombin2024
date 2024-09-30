
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.UserService;
import comarca.com.pe.amarinbombin.infrastructure.entity.TypeUser;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {
    
    private final UserService userService;      
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String register(UserEntity userEntity, Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }
    
    @PostMapping
    public String registerUser(@Valid UserEntity userEntity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        userEntity.setTypeUser(TypeUser.USER);  

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> log.info("Error {}", e.getDefaultMessage()));
            return "register"; 
        }

        userService.saveUser(userEntity); 
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/login";
    }
}