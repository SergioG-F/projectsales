package pe.com.nttdata.kafkaproduct.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.com.nttdata.kafkaproduct.service.INotificacionProductoService;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;

@Service
@Slf4j
@AllArgsConstructor
public class NotificacionKafkaProductConsumer {
    private final INotificacionProductoService notificacionProductoServiceService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    private void consumer(NotificacionProductoRequest notificacionKafkaRequest){
        log.info("Notificación Kafka consumer: {}", notificacionKafkaRequest);
        notificacionProductoServiceService.enviarNotificacion(notificacionKafkaRequest);
    }
}
