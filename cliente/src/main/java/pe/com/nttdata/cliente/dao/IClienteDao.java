package pe.com.nttdata.cliente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.cliente.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente,Integer> {
/*
    List<Cliente> findByRuc(Integer ruc);
    List<Cliente> findByEmail(String email);
    List<Cliente> findByRazonSocial(String razonSocial);
    List<Cliente> findByDireccion(String direccion);
    List<Cliente> findByTelefono(Integer telefono);
    List<Cliente> findByNombres(String nombres);
    List<Cliente> findByApellidos(String apellidos);
    List<Cliente> findByDescuento(float descuento);
    List<Cliente> findByFechaCreacion(LocalDate fechaCreacion);
    List<Cliente> findByEstado(Integer  estado);
    List<Cliente> findByIdProducto(Integer idProducto);
    List<Cliente> findByIdCiudad(Integer idCiudad);*/
}
