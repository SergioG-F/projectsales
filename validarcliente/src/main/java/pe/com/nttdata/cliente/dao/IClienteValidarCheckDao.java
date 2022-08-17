package pe.com.nttdata.cliente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.cliente.model.ValidarClienteCheck;

public interface IClienteValidarCheckDao extends JpaRepository<ValidarClienteCheck,Integer> {
}
