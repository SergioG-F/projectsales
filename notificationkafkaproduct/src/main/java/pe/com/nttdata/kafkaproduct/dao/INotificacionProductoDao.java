package pe.com.nttdata.kafkaproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.kafkaproduct.model.NotificacionProducto;

public interface INotificacionProductoDao extends JpaRepository<NotificacionProducto,Integer> {
}
