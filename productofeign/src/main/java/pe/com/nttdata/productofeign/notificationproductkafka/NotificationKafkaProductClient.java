package pe.com.nttdata.productofeign.notificationproductkafka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notificationkafkaproduct",
        url = "${productofeign.notificationkafkaproduct.url}"
)
public interface NotificationKafkaProductClient {
    //el path viene de notificacionkafka de pack controller NotificacionKafkaController

    @PostMapping(path = "api-projectsales/v1/notificationkafkaproduct")
    void enviarNotificacion(@RequestBody NotificationKafkaProductRequest notificacionKafkaproductRequest);
}
