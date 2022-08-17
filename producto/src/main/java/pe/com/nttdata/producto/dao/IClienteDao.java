package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente,Integer> {
}
