package pe.com.nttdata.notificacionproducto.controller;

public record NotificacionProductoRequest(
        Integer productoId,
        String productoEmail,
        // String remitente,
        String mensaje
        ) {
}


