package pe.com.nttdata.producto.service;

import pe.com.nttdata.producto.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> listProduct();
    public Producto obtenerProduct(Integer id);
    public Producto insertProduct(Producto producto);
    public String validarProduct(Producto producto);
    public void registrarNotificacionProduct(Producto producto);
    public Producto updateProduct(Producto producto);
    public int eliminarProduct(Integer id);


}
