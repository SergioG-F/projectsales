package pe.com.nttdata.producto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.producto.model.DetallePedido;
import pe.com.nttdata.producto.dao.IDetallePedidosDao;
import pe.com.nttdata.producto.service.IDetallePedidoService;

import java.util.List;
@Service
@AllArgsConstructor
public class DetallePedidoServiceImpl implements IDetallePedidoService {
    private final IDetallePedidosDao detallePedidosDao;

    public List<DetallePedido> listDetallePedido() {

        return detallePedidosDao.findAll();
    }

    public DetallePedido insertDetallePedido(DetallePedido detallePedido) {

        DetallePedido detallePedidoResponse = detallePedidosDao.save(detallePedido);
        return detallePedidoResponse;
    }

    public DetallePedido updateDetallePedido(DetallePedido detallePedido) {

        return detallePedidosDao.save(detallePedido);
    }

    public int eliminarDetallePedido(Integer id) {
        detallePedidosDao.deleteById(id);
        return 0;
    }

    public DetallePedido obtenerDetallePedido(Integer id) {
        return detallePedidosDao.findById(id).get();
    }
}
