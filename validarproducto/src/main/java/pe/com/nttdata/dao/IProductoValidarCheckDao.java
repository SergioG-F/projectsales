package pe.com.nttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.model.ValidarProductoCheck;

public interface IProductoValidarCheckDao extends JpaRepository<ValidarProductoCheck,Integer> {
}
