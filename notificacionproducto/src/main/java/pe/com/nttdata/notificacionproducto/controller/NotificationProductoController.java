package pe.com.nttdata.notificacionproducto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.notificacionproducto.service.INotificacionProductoService;

@RestController
@RequestMapping("api-projectsales/v1/notificacionproducto")
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
