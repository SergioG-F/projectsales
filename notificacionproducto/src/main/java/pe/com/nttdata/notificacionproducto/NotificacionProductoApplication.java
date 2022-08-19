package pe.com.nttdata.notificacionproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Como consume colas no es necesario que haga su feigncliente

@SpringBootApplication

public class NotificacionProductoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificacionProductoApplication.class, args);
    }
}