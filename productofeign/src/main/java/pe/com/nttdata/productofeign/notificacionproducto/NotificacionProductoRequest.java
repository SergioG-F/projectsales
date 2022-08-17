package pe.com.nttdata.productofeign.notificacionproducto;

public record NotificacionProductoRequest(
        Integer productoId,
   //     String productoEmail,
         String mensaje

) {
}
