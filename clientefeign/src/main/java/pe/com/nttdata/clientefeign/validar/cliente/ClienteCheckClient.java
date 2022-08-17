package pe.com.nttdata.clientefeign.validar.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//viene del properties de name de validarcliente
//@FeignClient("validarclientecheck")

@FeignClient(
        name="validarclientecheck",
        url = "${clientefeign.validarclientecheck.url}"
)
public interface ClienteCheckClient {
    //viene del controller de validarcliente
    @GetMapping(path = "api-projectsales/v1/cliente-check/{clienteId}")
    ValidarClienteCheckResponse validarCliente(@PathVariable("clienteId") Integer clienteId);
}
