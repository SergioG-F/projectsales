package pe.com.nttdata.cliente.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.cliente.model.Cliente;
import pe.com.nttdata.cliente.service.IClienteService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/cliente")
@AllArgsConstructor
public class ClienteController {
    private final IClienteService clienteService;
    @GetMapping
    public ResponseEntity<?> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        log.info("listar clientes {}",clientes.stream().toList());
        return new ResponseEntity<>(clientes, clientes.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.findById(id);
        log.info("obtener cliente: {}", cliente);
        return new ResponseEntity<>(cliente ,cliente!=null ?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
    //sin valid  INSERT...
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody Cliente cliente ){
        log.info("nuevo registro de cliente {}", cliente);
        Cliente newcliente = clienteService.save(cliente);
        return new ResponseEntity<>(newcliente , newcliente != null ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
    }
    /*
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> modificarCliente(@Valid @RequestBody Cliente cliente,@PathVariable Integer id) {
        Cliente clienteFind = clienteService.findById(id);
        clienteFind.setRuc(cliente.getRuc());
        clienteFind.setEmail(cliente.getEmail());
        clienteFind.setRazonSocial(cliente.getRazonSocial());
        clienteFind.setDireccion(cliente.getDireccion());
        clienteFind.setTelefono(cliente.getTelefono());
        clienteFind.setNombres(cliente.getNombres());
        clienteFind.setApellidos(cliente.getApellidos());
        clienteFind.setDescuento(cliente.getDescuento());
        clienteFind.setFechaCreacion(cliente.getFechaCreacion());
        clienteFind.setEstado(cliente.getEstado());
        clienteFind.setIdProducto(cliente.getIdProducto());
        clienteFind.setIdCiudad(cliente.getIdCiudad());
        log.info("modificar datos del cliente {}", clienteFind);
        Cliente clienteEdit =clienteService.modifyClient(clienteFind);
        return new ResponseEntity<Cliente>(clienteEdit,clienteEdit!=null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
*/
    //UPDATE CLIENTE
    @PutMapping
    public ResponseEntity<?>modificarCliente(@Valid @RequestBody Cliente cliente){
        log.info("UPDATE DATOS DE CLIENTE {}",cliente );;
        clienteService.modifyClient(cliente);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id) {
        log.info("eliminando cliente: ", id);
        boolean var = clienteService.deleteById(id);
        return new ResponseEntity<>(var?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
/*
    //Get For ruc
    @GetMapping(value = "/ruc/{ruc}")
    public ResponseEntity<?> obtenerByName(@PathVariable("ruc")Integer ruc){
        log.info("Obtener Cliente Por RUC",ruc);
        return new ResponseEntity<>(clienteService.listarClientesPorRuc(ruc),HttpStatus.OK);
    }

    //Get For Email
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<?> obtenerByEmail(@PathVariable("email")String email){
        log.info("Obtener Cliente Por Email",email);
        return new ResponseEntity<>(clienteService.listarClientesporEmail(email),HttpStatus.OK);
    }
    //Get For razonsocial
    @GetMapping(value = "/razonsocial/{razonSocial}")
    public ResponseEntity<?> obtenerByMaterno(@PathVariable("razonSocial")String razonSocial){
        log.info("Obtener Cliente Por razonSocial",razonSocial);
        return new ResponseEntity<>(clienteService.listarClientesPorRazonSocial(razonSocial),HttpStatus.OK);
    }
    //Get For direccion
    @GetMapping(value = "/direccion/{direccion}")
    public ResponseEntity<?> obtenerByDireccion(@PathVariable("direccion")String direccion){
        log.info("Obtener Cliente Por direccion",direccion);
        return new ResponseEntity<>(clienteService.listarClientesPorDireccion(direccion),HttpStatus.OK);
    }
    //Get For telefono
    @GetMapping(value = "/telefono/{telefono}")
    public ResponseEntity<?> obtenerByFecha(@PathVariable("telefono") Integer telefono){
        log.info("Obtener Cliente Por Telefono",telefono);
        return new ResponseEntity<>(clienteService.listarClientesPorTelefono(telefono),HttpStatus.OK);
    }
    //Get For nombres
    @GetMapping(value = "/nombres/{nombres}")
    public ResponseEntity<?> obtenerBynombres(@PathVariable("nombres") String nombres){
        log.info("Obtener Cliente Por nombres",nombres);
        //String li = email.formatted("dd/MM/yyyy");
        return new ResponseEntity<>(clienteService.listarClientesPorNombres(nombres),HttpStatus.OK);
    }
    //Get For apellidos
    @GetMapping(value = "/apellidos/{apellidos}")
    public ResponseEntity<?> obtenerByapellidos(@PathVariable("apellidos") String apellidos){
        log.info("Obtener Cliente Por apellidos",apellidos);
        return new ResponseEntity<>(clienteService.listarClientesPorApellidos(apellidos),HttpStatus.OK);
    }
    //Get For descuento
    @GetMapping(value = "/descuento/{descuento}")
    public ResponseEntity<?> obtenerByDescuento(@PathVariable("descuento") Integer descuento){
        log.info("Obtener Cliente Por descuento",descuento);
        return new ResponseEntity<>(clienteService.listarClientesPorDescuento(descuento),HttpStatus.OK);
    }
    //Get For Fecha Creacion
    @GetMapping(params ="fechaCreacion}")
    public ResponseEntity<?> obtenerByFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCreacion){
        log.info("Obtener Cliente Por fechaCreacion",fechaCreacion);
        return new ResponseEntity<>(clienteService.listarClientesPorFechaCreacion(fechaCreacion),HttpStatus.OK);
    }
    //Get For Estado
    @GetMapping(value = "/estado/{estado}")
    public ResponseEntity<?> obtenerByEstado(@PathVariable("estado") Integer estado){
        log.info("Obtener Cliente Por estado",estado);
        return new ResponseEntity<>(clienteService.listarClientesPorEstado(estado),HttpStatus.OK);
    }
    //Get For idProducto
    @GetMapping(value = "/idproducto/{idProducto}")
    public ResponseEntity<?> obtenerByidproducto(@PathVariable("idProducto") Integer idProducto){
        log.info("Obtener Cliente Por idproducto",idProducto);
        return new ResponseEntity<>(clienteService.listarClientesPorIdProducto(idProducto),HttpStatus.OK);
    }

    //Get For IdCiudad
    @GetMapping(value = "/idciudad/{idCiudad}")
    public ResponseEntity<?> obtenerByidCiudad(@PathVariable("idCiudad") Integer idCiudad){
        log.info("Obtener Cliente Por idciudad",idCiudad);
        return new ResponseEntity<>(clienteService.listarClientesPorIdCiudad(idCiudad),HttpStatus.OK);
    }


*/
/*
    //Validacion de parametros...
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody Cliente cliente) {
        log.info("nuevo registro de cliente {}", cliente);
        Cliente newcliente = clienteService.registrarCliente(cliente);
        return new ResponseEntity<ClienteRequest>(new ClienteRequest(cliente.getId(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno() , cliente.getEmail(), cliente.getFechaNacimiento()), HttpStatus.OK);
    }
*/

/*
    @PutMapping
    public ResponseEntity<?> modificarCliente(@Valid @RequestBody Cliente cliente) {
        log.info("modificar datos de cliente {}", cliente);
        clienteService.modificarCliente(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
*/

}
