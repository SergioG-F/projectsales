package pe.com.nttdata.cliente.controller;
import pe.com.nttdata.cliente.model.Ciudad;
import java.time.LocalDate;
public record ClienteRequest(
        Integer idCliente,
        Integer	ruc,
        String	email,
        String	razonSocial,
        String	direccion,
        Integer	telefono,
        String	nombres,
        String	apellidos,
        Integer	descuento,
        LocalDate fechaCreacion,
        Integer	estado,
        Ciudad ciudad) {
}
