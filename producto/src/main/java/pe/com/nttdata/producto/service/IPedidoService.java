package pe.com.nttdata.producto.service;

import pe.com.nttdata.producto.model.Pedido;

import java.util.List;

public interface IPedidoService {
    public List<Pedido> listPedido();
    public Pedido obtenerPedido(Integer id);
    public Pedido insertPedido(Pedido pedido);
    public Pedido updatePedido(Pedido pedido);
    public int eliminarPedido(Integer id);
}
