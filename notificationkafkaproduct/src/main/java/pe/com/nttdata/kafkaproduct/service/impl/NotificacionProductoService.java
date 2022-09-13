package pe.com.nttdata.kafkaproduct.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import pe.com.nttdata.kafkaproduct.dao.INotificacionProductoDao;
import pe.com.nttdata.kafkaproduct.model.NotificacionProducto;
import pe.com.nttdata.kafkaproduct.service.INotificacionProductoService;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;
import pe.com.nttdata.productofeign.notificationproductkafka.NotificationKafkaProductRequest;

import java.util.Date;

@Service
@AllArgsConstructor
public class NotificacionProductoService implements INotificacionProductoService {
    private final INotificacionProductoDao notificacionproductoDao;

    public boolean enviarNotificacion(NotificationKafkaProductRequest notificaproductoRequest){
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
