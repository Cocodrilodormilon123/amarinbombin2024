
package comarca.com.pe.amarinbombin.app.service;

import comarca.com.pe.amarinbombin.app.repository.UserRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserEntity> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserEntity getUserById(Integer idU) {
        return userRepository.getUserById(idU);
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.saveUser(userEntity);
    }

    public boolean deleteUserById(Integer idU) {
        return userRepository.deleteUserById(idU);
    }
    public UserEntity findByCorreoAndContrasena(String correo, String contrasena) {
    return userRepository.findByCorreoAndContrasena(correo, contrasena);
}
}