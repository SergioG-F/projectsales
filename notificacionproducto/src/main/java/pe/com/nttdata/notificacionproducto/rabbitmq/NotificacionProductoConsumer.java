package pe.com.nttdata.notificacionproducto.rabbitmq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.com.nttdata.notificacionproducto.service.INotificacionProductoService;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;

@Component
@AllArgsConstructor
@Slf4j
public class NotificacionProductoConsumer {
    private final INotificacionProductoService notificacionproductoService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificacionProductoRequest notificacionproductoRequest) {
        log.info("Consumido {} desde cola", notificacionproductoRequest);
        notificacionproductoService.enviarNotificacion(notificacionproductoRequest);
    }
}
