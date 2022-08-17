package pe.com.nttdata.cliente.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.cliente.dao.IClienteValidarCheckDao;
import pe.com.nttdata.cliente.model.ValidarClienteCheck;

import java.util.Date;

@Service
@AllArgsConstructor
public class ClienteCheckService implements IClienteCheckService {
    private final IClienteValidarCheckDao clienteCheckDao;
    public boolean esClienteFraudulento(Integer clienteId) {
        clienteCheckDao.save(
                ValidarClienteCheck.builder()
                        .clienteId(clienteId)
                        .esEstafador(false)
                        .fechaCreacion(new Date())
                        .build()
        );
        return false;
    }
}
