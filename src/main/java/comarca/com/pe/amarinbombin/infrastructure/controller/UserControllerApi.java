
package comarca.com.pe.amarinbombin.infrastructure.controller;

import comarca.com.pe.amarinbombin.app.service.UserService;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserControllerApi {

    private final UserService userService;

    public UserControllerApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<UserEntity> listUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public UserEntity getUserById(@PathVariable Integer idU) {
        return userService.getUserById(idU);
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser(@PathVariable Integer idU, @RequestBody UserEntity userEntity) {
        userEntity.setIdU(idU);
        return userService.saveUser(userEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Integer idU) {
        return userService.deleteUserById(idU);
    }
}