package pe.com.nttdata.producto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.producto.dao.IPedidosDao;
import pe.com.nttdata.producto.model.Pedido;
import pe.com.nttdata.producto.service.IPedidoService;

import java.util.List;
@Service
@AllArgsConstructor
public class PedidoServiceImpl implements IPedidoService {
    private final IPedidosDao pedidosDao;

    public List<Pedido> listPedido() {
        return pedidosDao.findAll();
    }

    public Pedido obtenerPedido(Integer id) {
        return pedidosDao.findById(id).get();
    }

    public Pedido insertPedido(Pedido pedido) {
        Pedido pedidoResponse= pedidosDao.save(pedido);
        return pedidoResponse;
    }

    public Pedido updatePedido(Pedido pedido) {
        return pedidosDao.save(pedido);
    }

    public int eliminarPedido(Integer id) {
         pedidosDao.deleteById(id);
        return 0;

    }
}
