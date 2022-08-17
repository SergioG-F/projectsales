package pe.com.nttdata.productofeign.notificacionproducto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Viene del properties.
//@FeignClient("notificacionproducto")

@FeignClient(
        //Viene del properties del microservicios su name.
        name="notificacionproducto",
        url = "${productofeign.notificacionproducto.url}"
)
public interface NotificacionProducto {
    //el path viene de notificacionproducto de pack controller NotificacionProductoController
    @PostMapping(path = "api-projectsales/v1/notificacionproducto")
    void enviarNotificacion(@RequestBody NotificacionProductoRequest notificacionproductoRequest);
}

