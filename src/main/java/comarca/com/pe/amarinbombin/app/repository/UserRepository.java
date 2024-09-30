package comarca.com.pe.amarinbombin.app.repository;

import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;

public interface UserRepository {
    Iterable<UserEntity> getAllUsers();
    UserEntity getUserById(Integer idU);
    UserEntity saveUser(UserEntity userEntity);
    boolean deleteUserById(Integer idU);
    UserEntity findByCorreoAndContrasena(String correo, String contrasena);
}