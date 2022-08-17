package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.CategoriaProducto;

public interface ICategoriaProductoDao extends JpaRepository<CategoriaProducto,Integer> {
}
