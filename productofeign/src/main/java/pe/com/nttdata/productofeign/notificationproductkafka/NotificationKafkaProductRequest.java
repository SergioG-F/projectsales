package pe.com.nttdata.productofeign.notificationproductkafka;

public record NotificationKafkaProductRequest(
        Integer productoId,
        String productoEmail,
        // String remitente,
        String mensaje
     /*
        Integer productoId,
   //     String productoEmail,
         String mensaje
*/
) {
}
