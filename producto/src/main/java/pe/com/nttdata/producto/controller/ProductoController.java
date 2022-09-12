package pe.com.nttdata.producto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.producto.service.IProductoService;
import pe.com.nttdata.producto.model.Producto;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/producto")
@AllArgsConstructor
public class ProductoController {

    private final IProductoService productoService;
    //LISTAR ALL
    @GetMapping
    public ResponseEntity<?> listarProduct() {
        List<Producto> productos = productoService.listProduct();
        log.info("listar Productos");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    //BUSCAR POR ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerProduct(@PathVariable("id") Integer id) {
        log.info("obtener Producto: ", id);

        return new ResponseEntity<>(productoService.obtenerProduct(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarProduct(@Valid @RequestBody Producto producto) {
        log.info("nuevo registro de Producto {}", producto);
        Producto newproducto = productoService.insertProduct(producto);
        String resultado = productoService.validarProduct(newproducto);
        log.info("Resultado  {}", resultado);

        if(resultado.equals("OK")){
            productoService.registrarNotificacionProduct(newproducto);
            //Insert Kafka Product
            productoService.registrarNotificacionKafkaProduct(newproducto);

            return new ResponseEntity<>(newproducto , newproducto != null ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Servicio Validar Producto No Disponible ",HttpStatus.OK);
    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Producto producto) {
        log.info("modificar datos de Procut {}", producto);
        productoService.updateProduct(producto);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
    //ELIMINAR
    @DeleteMapping(value = "/{id}")
    public void eliminarProduct(@PathVariable("id") Integer id) {
        log.info("eliminar Product: ", id);
        productoService.eliminarProduct(id);
    }
}
