package pe.com.nttdata.kafkaproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Como consume colas no es necesario que haga su feigncliente
@SpringBootApplication

public class NotificationKafkaProducApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationKafkaProducApplication.class, args);
    }

}
