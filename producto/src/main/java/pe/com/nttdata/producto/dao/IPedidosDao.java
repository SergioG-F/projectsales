package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.Pedido;

public interface IPedidosDao extends JpaRepository<Pedido,Integer> {
}
