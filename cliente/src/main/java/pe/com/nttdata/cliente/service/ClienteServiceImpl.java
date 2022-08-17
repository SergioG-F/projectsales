package pe.com.nttdata.cliente.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.nttdata.clientefeign.validar.cliente.ClienteCheckClient;
import pe.com.nttdata.clientefeign.validar.cliente.ValidarClienteCheckResponse;
import pe.com.nttdata.cliente.controller.NotificacionRequest;
import pe.com.nttdata.cliente.dao.IClienteDao;
import pe.com.nttdata.cliente.model.Cliente;
import pe.com.nttdata.clientequeues.rabbitmq.RabbitMQMessageProducer;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;
    private final ClienteCheckClient clienteCheckClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return clienteDao.findAll();
    }


    public Cliente save(Cliente cliente)  {
         Cliente clienteResponse = clienteDao.save(cliente);
         ValidarClienteCheckResponse validarClienteCheckResponse = clienteCheckClient.validarCliente(
                    clienteResponse.getIdCliente());
         if (validarClienteCheckResponse.esEstafador()){
             throw new IllegalStateException ("El CLIENTE ES UN ESTAFADOR");
         }

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
         return clienteResponse;
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
