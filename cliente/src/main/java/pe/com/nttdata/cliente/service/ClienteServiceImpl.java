package pe.com.nttdata.cliente.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.nttdata.cliente.kafka.producer.ClienteProducer;
import pe.com.nttdata.clientefeign.notificacionkafka.NotificacionKafkaRequest;
import pe.com.nttdata.clientefeign.validar.cliente.ClienteCheckClient;
import pe.com.nttdata.clientefeign.validar.cliente.ValidarClienteCheckResponse;
import pe.com.nttdata.cliente.controller.NotificacionRequest;
import pe.com.nttdata.cliente.dao.IClienteDao;
import pe.com.nttdata.cliente.model.Cliente;
import pe.com.nttdata.clientequeues.rabbitmq.RabbitMQMessageProducer;


import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;
    private final ClienteCheckClient clienteCheckClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    //KAFKA CONFIGURACION
    private final ClienteProducer clienteProducer;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return clienteDao.findAll();
    }


    public Cliente registrarCliente(Cliente cliente)  {
         Cliente clienteResponse = clienteDao.save(cliente);
         return clienteResponse;
    }


    @CircuitBreaker(name="validarclienteCB",fallbackMethod = "fallValidarClienteCB")
    @Retry(name="validarclienteRetry")
    public String validarCliente(Cliente cliente)  {
        log.info("ESTOY EN METODO VALIDARCLIENTE");

        ValidarClienteCheckResponse validarClienteCheckResponse = clienteCheckClient.validarCliente(
                cliente.getIdCliente());
        if (validarClienteCheckResponse.esEstafador()){
            throw new IllegalStateException ("El CLIENTE ES UN ESTAFADOR");
        }
        return "OK";
    }

    public String fallValidarClienteCB(Cliente cliente, Exception e){
        //AQUI PODEMOS LLAMAR A OTRO MICROSERVICIO DEPENDE LA LOGICA
        return "NO_OK";

    }

    public void registrarNotificacion(Cliente cliente)  {
       NotificacionRequest notificacionRequest = new NotificacionRequest(
                cliente.getIdCliente(),
                cliente.getEmail(),
                String.format("Hola %s, bienvenidos a NTTData...",
                        cliente.getNombres())
        );

        rabbitMQMessageProducer.publish(
                notificacionRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
    //KAFKA METODO
    public void registrarNotificacionKafka(Cliente cliente) {
        NotificacionKafkaRequest notificacionKafkaRequest = new NotificacionKafkaRequest(
                cliente.getIdCliente(),
                cliente.getEmail(),
                String.format("Hola %s, bienvenidos a NTTData...",
                        cliente.getNombres())
        );
        clienteProducer.enviarMensaje(notificacionKafkaRequest);
    }


    @Override
    public Cliente modifyClient(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public boolean deleteById(Integer idCliente){
        Optional<Cliente> cliente = clienteDao.findById(idCliente);
        if(cliente.isPresent()){
            clienteDao.deleteById(idCliente);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }
}
