package pe.com.nttdata.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
        (
                scanBasePackages = {
                        //Escanea toda La carpeta Principal pe.com.nttdata.producto del microservicio Producto
                        "pe.com.nttdata.producto",
                        //Escanea toda La carpeta Principal pe.com.nttdata.productoqueues del microservicio ProductoQueues
                        "pe.com.nttdata.productoqueues"
                }
        )
@EnableFeignClients(
        //Escanea toda La carpeta Principal pe.com.nttdata.productofeign de la liberia ProductoFeign
        basePackages = "pe.com.nttdata.productofeign"
)

@PropertySources({
        //Escanea La carpeta resources productofeign-default.properties de la liberia ProductoFeign de manera local
        @PropertySource("classpath:productofeign-${spring.profiles.active}.properties")
})
public class ProductoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductoApplication.class, args);
    }
}