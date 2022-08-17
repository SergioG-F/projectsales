package pe.com.nttdata.producto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.producto.model.Pedido;
import pe.com.nttdata.producto.service.IPedidoService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/pedido")
@AllArgsConstructor
public class PedidoController {
    private final IPedidoService pedidoService;

    //LISTAR ALL
    @GetMapping
    public ResponseEntity<?> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listPedido();
        log.info("listas de Pedidos");
        return new ResponseEntity<>(pedidos, pedidos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    //BUSCAR POR ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenePedido(@PathVariable("id") Integer id) {
        log.info("obtener Pedidos: ", id);
        return new ResponseEntity<>(pedidoService.obtenerPedido(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarPedido(@Valid @RequestBody Pedido pedido) {
        log.info("nuevo registro de Detalle pedido {}", pedido);
        Pedido newpedido = pedidoService.insertPedido(pedido);
        return new ResponseEntity<>(newpedido, newpedido != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<?> updatePedido(@Valid @RequestBody Pedido pedido) {
        log.info("modificar datos de pedido {}", pedido);
        pedidoService.updatePedido(pedido);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }
    //ELIMINAR
    @DeleteMapping(value = "/{id}")
    public void eliminarpedido(@PathVariable("id") Integer id) {
        log.info("eliminar e pedido: ", id);
        pedidoService.eliminarPedido(id);
    }
}
