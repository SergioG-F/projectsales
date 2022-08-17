package pe.com.nttdata.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.producto.model.DetallePedido;

public interface IDetallePedidosDao extends JpaRepository<DetallePedido,Integer> {
}
