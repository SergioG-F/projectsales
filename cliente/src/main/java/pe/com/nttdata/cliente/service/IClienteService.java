package pe.com.nttdata.cliente.service;

import pe.com.nttdata.cliente.model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> listarClientes();
    //public Cliente registrarCliente(Cliente cliente);
    public Cliente save(Cliente cliente);
    public Cliente modifyClient(Cliente cliente);
    public boolean deleteById(Integer idCliente);
    public Cliente findById(Integer id);
/*
    public List<Cliente> listarClientesPorRuc(Integer ruc);
    public List<Cliente> listarClientesporEmail(String email);
    public List<Cliente> listarClientesPorRazonSocial(String razonsocial);
    public List<Cliente> listarClientesPorDireccion(String direccion);
    public List<Cliente> listarClientesPorTelefono(Integer telefono);
    public List<Cliente> listarClientesPorNombres(String nombres);
    public List<Cliente> listarClientesPorApellidos(String apellidos);
    public List<Cliente> listarClientesPorDescuento(Integer descuento);
    public List<Cliente> listarClientesPorFechaCreacion(LocalDate fechaCreacion);
    public List<Cliente> listarClientesPorEstado(Integer estado);
    public List<Cliente> listarClientesPorIdProducto(Integer idproducto);
    public List<Cliente> listarClientesPorIdCiudad(Integer idciudad);*/
}
