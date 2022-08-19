package pe.com.nttdata.notificacionproducto.service;
//import pe.com.nttdata.notificacionproducto.controller.NotificacionProductoRequest;

import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;

public interface INotificacionProductoService {
    public boolean enviarNotificacion(NotificacionProductoRequest notificaRequest) ;

}
