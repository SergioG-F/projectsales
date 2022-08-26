package pe.com.nttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.model.Usuario;

import java.util.Optional;

public interface IUsuarioDao extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsuario(String usuario);

}
