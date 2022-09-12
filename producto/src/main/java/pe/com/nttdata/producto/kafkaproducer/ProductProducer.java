package pe.com.nttdata.producto.kafkaproducer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pe.com.nttdata.productofeign.notificationproductkafka.NotificationKafkaProductRequest;

@Service
@Slf4j
public class ProductProducer {

    private NewTopic topic;
    private KafkaTemplate<String, NotificationKafkaProductRequest> kafkaTemplate;

    public ProductProducer(NewTopic topic, KafkaTemplate<String, NotificationKafkaProductRequest> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensaje(NotificationKafkaProductRequest notificacionKafkaRequest){
        log.info("Notificación Kafka Product producer: {}", notificacionKafkaRequest);

        Message<NotificationKafkaProductRequest> message = MessageBuilder
                .withPayload(notificacionKafkaRequest)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
