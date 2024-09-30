
package comarca.com.pe.amarinbombin.infrastructure.configuration;

import comarca.com.pe.amarinbombin.app.repository.*;
import comarca.com.pe.amarinbombin.app.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public AlmacenService almacenService(AlmacenRepository almacenRepository) {
        return new AlmacenService(almacenRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public PedidoService pedidoService(PedidoRepository pedidoRepository) {
        return new PedidoService(pedidoRepository);
    }

    @Bean
    public DetallePedidoService detallePedidoService(DetallePedidoRepository detallePedidoRepository) {
        return new DetallePedidoService(detallePedidoRepository);
    }

    @Bean
    public TransaccionService transaccionService(TransaccionRepository transaccionRepository) {
        return new TransaccionService(transaccionRepository);
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }
}