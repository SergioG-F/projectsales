package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.Ciudad;

public interface ICiudadDao extends JpaRepository<Ciudad,Integer> {
}
