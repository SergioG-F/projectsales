package pe.com.nttdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "pe.com.nttdata.productofeign"
)
public class ValidarProductoCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidarProductoCheckApplication.class, args);
    }
}