package pe.com.nttdata.notificacionproducto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.notificacionproducto.model.NotificacionProducto;

public interface INotificacionProductoDao extends JpaRepository<NotificacionProducto,Integer> {
}
