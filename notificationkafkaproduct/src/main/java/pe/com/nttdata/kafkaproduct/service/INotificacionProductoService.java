package pe.com.nttdata.kafkaproduct.service;
import pe.com.nttdata.productofeign.notificationproductkafka.NotificationKafkaProductRequest;

public interface INotificacionProductoService {
    public boolean enviarNotificacion(NotificationKafkaProductRequest notificaproductoRequest) ;

}
