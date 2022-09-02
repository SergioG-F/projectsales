package pe.com.nttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.model.Product;

import java.util.Optional;

public interface IProductoDao extends JpaRepository<Product,Integer> {
    Optional<Product> findByProduct(String productusuario);

}
