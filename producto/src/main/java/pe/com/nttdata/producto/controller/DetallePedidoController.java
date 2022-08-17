package pe.com.nttdata.producto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.producto.model.DetallePedido;
import pe.com.nttdata.producto.service.IDetallePedidoService;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/detallepedido")
@AllArgsConstructor
public class DetallePedidoController {
    private final IDetallePedidoService detallePedidoService;

    //LISTAR ALL
    @GetMapping
    public ResponseEntity<?> listarDetallePedidos() {
        List<DetallePedido> detallepedidos = detallePedidoService.listDetallePedido();
        log.info("listas de Detalle Pedidos");
        return new ResponseEntity<>(detallepedidos, detallepedidos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    //BUSCAR POR ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obteneDetallePedido(@PathVariable("id") Integer id) {
        log.info("obtener Detalle Pedidos: ", id);
        return new ResponseEntity<>(detallePedidoService.obtenerDetallePedido(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrardetallePedido(@Valid @RequestBody DetallePedido detallePedido) {
        log.info("nuevo registro de Detalle pedido {}", detallePedido);
        DetallePedido newdetallepedido = detallePedidoService.insertDetallePedido(detallePedido);
        return new ResponseEntity<>(newdetallepedido, newdetallepedido != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<?> updatedetallePedido(@Valid @RequestBody DetallePedido detallePedido) {
        log.info("modificar datos de  Detalle pedido {}", detallePedido);
        detallePedidoService.updateDetallePedido(detallePedido);
        return new ResponseEntity<DetallePedido>(detallePedido, HttpStatus.OK);
    }
    //ELIMINAR
    @DeleteMapping(value = "/{id}")
    public void eliminardetallepedido(@PathVariable("id") Integer id) {
        log.info("eliminar e Detalle pedido: ", id);
        detallePedidoService.eliminarDetallePedido(id);
    }
}
