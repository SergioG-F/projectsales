package pe.com.nttdata.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.dao.IProductoValidarCheckDao;
import pe.com.nttdata.model.ValidarProductoCheck;

import java.util.Date;

@Service
@AllArgsConstructor
public class ProductoCheckService implements IProductoCheckService {
    private final IProductoValidarCheckDao productoValidarCheckDao;
    public boolean esProductoFraudulento(Integer clienteId) {
        productoValidarCheckDao.save(
                ValidarProductoCheck.builder()
                        .productoId(clienteId)
                        .esEstafador(false)
                        .fechaCreacion(new Date())
                        .build()
        );
        return false;
    }
}
