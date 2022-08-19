package pe.com.nttdata.producto.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.nttdata.producto.dao.IProductoDao;
import pe.com.nttdata.producto.model.Producto;
import pe.com.nttdata.producto.service.IProductoService;
import pe.com.nttdata.productofeign.notificacionproducto.NotificacionProductoRequest;
import pe.com.nttdata.productofeign.validarproducto.ProductoCheck;
import pe.com.nttdata.productofeign.validarproducto.ValidarProductoCheckResponse;
import pe.com.nttdata.productoqueues.rabbitmq.RabbitMQMessageProducer;

import java.util.List;
@Slf4j

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {
    private final IProductoDao productoDao;

    //PARA VALIDAR PRODUCTO ANTES DE INSERTAR LLAMAR PRODUCTO FEIGN registrar en el pom
    private final ProductoCheck productoCheck;

    //PARA ENVIAR MENSAJE A LA COLA ANTES DE INSERTAR LLAMAR PRODUCTOQUEUES registrar en el pom
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public List<Producto> listProduct() {
        return productoDao.findAll();
    }
    public Producto insertProduct(Producto producto) {

        Producto productoResponse = productoDao.save(producto);
        return productoResponse;
    }
    @CircuitBreaker(name="validarclienteCB",fallbackMethod = "fallValidarClienteCB")
    @Retry(name="validarclienteRetry")
    public String validarProduct(Producto producto) {
        log.info("ESTOY EN METODO VALIDARPRODUCTO");

        //ANTES DE INSERTAR VALIDAMOS SI ES UN PRODUCTO ESTAFADO
        //llamamos al ValidarProductoCheckResponse que viene del productofeign
        ValidarProductoCheckResponse validarProductoCheckResponse = productoCheck.validarProducto(
                producto.getIdProducto());
        if(validarProductoCheckResponse.esEstafador()){
            throw new IllegalStateException("EL PRODUCTO ES ESTAFADO");
        }
        return "NO_OK";
    }
    public String fallValidarClienteCB(Producto producto, Exception e){
        //AQUI PODEMOS LLAMAR A OTRO MICROSERVICIO DEPENDE LA LOGICA
        return "NO_OK";

    }

    public void registrarNotificacionProduct(Producto producto) {

        //llamamos al NotificacionProductoRequest que viene del productofeign
        //dentro del cuerpo enviamos los parametros que elegimos.

        NotificacionProductoRequest notificacionProductoRequest = new NotificacionProductoRequest(
                producto.getIdProducto(),
                String.format("Producto :  %s. Bienvenidos a ProjectSales ",
                        producto.getDescripcion())
        );

        //Generamos la cola si en caso de que cae el http queda aun en memoria
        rabbitMQMessageProducer.publish(
                notificacionProductoRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

    }


    public Producto updateProduct(Producto producto) {

        return productoDao.save(producto);
    }

    public int eliminarProduct(Integer id) {
        productoDao.deleteById(id);
        return 0;
    }

    public Producto obtenerProduct(Integer id) {
        return productoDao.findById(id).get();
    }

}
