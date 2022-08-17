package pe.com.nttdata.notificacionproducto.service;
import pe.com.nttdata.notificacionproducto.controller.NotificacionProductoRequest;

public interface INotificacionProductoService {
    public boolean enviarNotificacion(NotificacionProductoRequest notificaRequest) ;

}
