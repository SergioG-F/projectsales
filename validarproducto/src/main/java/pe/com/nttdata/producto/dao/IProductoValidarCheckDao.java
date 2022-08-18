package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.ValidarProductoCheck;

public interface IProductoValidarCheckDao extends JpaRepository<ValidarProductoCheck,Integer> {
}
