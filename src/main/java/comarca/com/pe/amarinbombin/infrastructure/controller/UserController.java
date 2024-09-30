package comarca.com.pe.amarinbombin.infrastructure.controller;


import comarca.com.pe.amarinbombin.app.service.UserService;
import comarca.com.pe.amarinbombin.infrastructure.entity.TypeUser;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Integer idU, Model model) {
        UserEntity user = userService.getUserById(idU);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer idU) {
        userService.deleteUserById(idU);
        return "redirect:/users/list";
    }
}