package pe.com.nttdata.clientefeign.notificacion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Viene del properties.
//@FeignClient("notificacion")

@FeignClient(
        name="notificacion",
        url = "${clientefeign.notificacion.url}"
)
public interface NotificacionClient {
    //el path viene de notificacion de pack controller NotificacionController
    @PostMapping(path = "api-projectsales/v1/notificacion")
    void enviarNotificacion(@RequestBody NotificacionRequest notificacionRequest);
}

