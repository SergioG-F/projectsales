package pe.com.nttdata.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "pe.com.nttdata.clientefeign"
)

public class ValidarClienteCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidarClienteCheckApplication.class, args);
    }
}