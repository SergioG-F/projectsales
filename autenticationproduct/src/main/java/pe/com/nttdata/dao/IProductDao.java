package pe.com.nttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.model.ProductUsuario;

import java.util.Optional;

public interface IProductDao extends JpaRepository<ProductUsuario,Integer> {
    Optional<ProductUsuario> findByProduct(String product);

}
