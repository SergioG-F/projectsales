package pe.com.nttdata.notificacion.controller;

public record NotificacionRequest(
        Integer clienteId,
        String clienteEmail,
       // String remitente,
        String mensaje
        ) {
}


