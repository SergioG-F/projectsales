package pe.com.nttdata.productofeign.notificationproductkafka;

public record NotificationKafkaProductRequest(
        Integer productoId,
        Integer precio,
        // String remitente,
        String mensaje
     /*
        Integer productoId,
   //     String productoEmail,
         String mensaje
*/
) {
}
