package pe.com.nttdata.cliente.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.cliente.service.IClienteCheckService;
import pe.com.nttdata.clientefeign.validar.cliente.ValidarClienteCheckResponse;

@Slf4j
@RestController
@RequestMapping("api-projectsales/v1/cliente-check")
@AllArgsConstructor
public class ValidarClienteCheckController {
    private final IClienteCheckService clienteCheckService;

    @GetMapping(path = "{clienteId}")
    public ValidarClienteCheckResponse validarCliente(
            @PathVariable("clienteId") Integer clienteId) {
        boolean esEstafador = clienteCheckService.
                esClienteFraudulento(clienteId);
        log.info("validacion para cliente: {}", clienteId);

        return new ValidarClienteCheckResponse(esEstafador);
    }
}
