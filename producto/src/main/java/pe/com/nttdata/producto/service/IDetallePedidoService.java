package pe.com.nttdata.producto.service;

import pe.com.nttdata.producto.model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {
    public List<DetallePedido> listDetallePedido();
    public DetallePedido obtenerDetallePedido(Integer id);
    public DetallePedido insertDetallePedido(DetallePedido detallePedido);
    public DetallePedido updateDetallePedido(DetallePedido detallePedido);
    public int eliminarDetallePedido(Integer id);
}
