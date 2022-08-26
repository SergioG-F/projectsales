package pe.com.nttdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.dto.NuevoUsuarioDto;
import pe.com.nttdata.dto.RequestDto;
import pe.com.nttdata.dto.TokenDto;
import pe.com.nttdata.dto.UsuarioDto;
import pe.com.nttdata.model.Usuario;
import pe.com.nttdata.service.UsuarioService;

@RestController
@RequestMapping("api-projectsales/v1/autenticacion")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UsuarioDto dto){
        TokenDto tokenDto = usuarioService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validar")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto){
        TokenDto tokenDto = usuarioService.validate(token, dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> create(@RequestBody NuevoUsuarioDto dto){
        Usuario usuario = usuarioService.save(dto);
        if(usuario == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(usuario);
    }
}
