package pe.com.nttdata.kafkaproduct.service;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;

public interface INotificacionProductoService {
    public boolean enviarNotificacion(NotificacionProductoRequest notificaRequest) ;

}
