package pe.com.nttdata.notificacionproducto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.notificacionproducto.controller.NotificacionProductoRequest;
import pe.com.nttdata.notificacionproducto.dao.INotificacionProductoDao;
import pe.com.nttdata.notificacionproducto.model.NotificacionProducto;
import pe.com.nttdata.notificacionproducto.service.INotificacionProductoService;

import java.util.Date;

@Service
@AllArgsConstructor
public class NotificacionProductoService implements INotificacionProductoService {
    private final INotificacionProductoDao notificacionproductoDao;

    public boolean enviarNotificacion(NotificacionProductoRequest notificaproductoRequest){
        notificacionproductoDao.save(
                NotificacionProducto.builder()
                        .productoId(notificaproductoRequest.productoId())
        //.productoEmail(notificaproductoRequest.productoEmail())
                        .productoEmail("TiendaEcommercer.trujillo.com.pe")
                        .remitente("PRODUCTO NTTDATA")
                        .mensaje(notificaproductoRequest.mensaje())
                        .horaEnvio(new Date())
                        .build()
        );
        return false;

    }


}
