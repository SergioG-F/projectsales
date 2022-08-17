package pe.com.nttdata.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.service.IProductoCheckService;
import pe.com.nttdata.productofeign.validarproducto.ValidarProductoCheckResponse;


@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/producto-check")
@AllArgsConstructor
public class ValidarProductoCheckController {
    private final IProductoCheckService productoCheckService;
    @GetMapping(path = "{productoId}")
    // validarproductocheckResponse viene del feign tenemos que crear ahy
    public ValidarProductoCheckResponse validarProducto(
            @PathVariable("productoId") Integer productoId) {
        boolean esEstafador = productoCheckService.
                esProductoFraudulento(productoId);
        log.info("validacion para el Producto: {}", productoId);

        // validarproductocheckResponse viene del feign tenemos que crear ahy

        return new ValidarProductoCheckResponse(esEstafador);
    }
}
