package pe.com.nttdata.productofeign.notificacionproducto;

public record NotificacionProductoRequest(
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
