package pe.com.nttdata.productofeign.validarproducto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//viene del properties de name de validarproductocheck
//@FeignClient("validarproductocheck")

@FeignClient(
        //viene del properties o YML de name de validarproductocheck del microservicios
        name="validarproductocheck",
        url = "${productofeign.validarproductocheck.url}"
)
public interface ProductoCheck {
    //viene del controller de ValidarProductoCheckController
    @GetMapping(path = "api-projectsales/v1/producto-check/{productoId}")
    ValidarProductoCheckResponse validarProducto(@PathVariable("productoId") Integer productoId);
}
