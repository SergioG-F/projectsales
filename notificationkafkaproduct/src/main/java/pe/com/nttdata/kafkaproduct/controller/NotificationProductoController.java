package pe.com.nttdata.kafkaproduct.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.kafkaproduct.service.INotificacionProductoService;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;

@RestController
@RequestMapping("api-projectsales/v1/notificationkafkaproduct")
@AllArgsConstructor
@Slf4j
public class NotificationProductoController {
    private final INotificacionProductoService notificacionproductoService;

    @PostMapping
    public void enviarNotificacion(@RequestBody NotificacionProductoRequest notificacionproductoRequest) {
        log.info("Nueva notificacion... {}", notificacionproductoRequest);
        notificacionproductoService.enviarNotificacion(notificacionproductoRequest);
    }
}
