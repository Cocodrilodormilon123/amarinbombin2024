package comarca.com.pe.amarinbombin.infrastructure.adapter;

import comarca.com.pe.amarinbombin.app.repository.UserRepository;
import comarca.com.pe.amarinbombin.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public Iterable<UserEntity> getAllUsers() {
        return userCrudRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer idU) {
        return userCrudRepository.findById(idU).orElse(null);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public boolean deleteUserById(Integer idU) {
        userCrudRepository.deleteById(idU);
        return true;
    }

    @Override
    public UserEntity findByCorreoAndContrasena(String correo, String contrasena) {
        return userCrudRepository.findByCorreoAndContrasena(correo, contrasena); // Usando el método de búsqueda
    }
}
