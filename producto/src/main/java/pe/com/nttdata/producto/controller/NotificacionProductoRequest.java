package pe.com.nttdata.producto.controller;

public record NotificacionProductoRequest(
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
