package pe.com.nttdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.dto.NuevoProductDto;
import pe.com.nttdata.dto.RequestDto;
import pe.com.nttdata.dto.TokenDto;
import pe.com.nttdata.dto.ProductDto;
import pe.com.nttdata.model.ProductUsuario;
import pe.com.nttdata.service.ProductUsuarioService;

@RestController
@RequestMapping("api-projectsales/v1/autenticationproduct")
public class ProductController {
    @Autowired
    ProductUsuarioService productusuarioService;

    @PostMapping("/loginproduct")
    public ResponseEntity<TokenDto> login(@RequestBody ProductDto dto){
        TokenDto tokenDto = productusuarioService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validarproduct")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto){
        TokenDto tokenDto = productusuarioService.validate(token, dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/crearproduct")
    public ResponseEntity<ProductUsuario> create(@RequestBody NuevoProductDto dto){
        ProductUsuario usuario = productusuarioService.save(dto);
        if(usuario == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(usuario);
    }
}
