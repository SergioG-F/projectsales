package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.Producto;

public interface IProductoDao extends JpaRepository<Producto,Integer> {

}
