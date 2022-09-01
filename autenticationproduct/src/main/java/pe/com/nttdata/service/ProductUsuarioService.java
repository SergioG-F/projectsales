package pe.com.nttdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.nttdata.dao.IProductDao;
import pe.com.nttdata.dto.NuevoProductDto;
import pe.com.nttdata.dto.RequestDto;
import pe.com.nttdata.dto.TokenDto;
import pe.com.nttdata.dto.ProductDto;
import pe.com.nttdata.model.ProductUsuario;
import pe.com.nttdata.security.JwtProvider;

import java.util.Optional;

@Service
public class ProductUsuarioService {
    @Autowired
    IProductDao productusuarioDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public ProductUsuario save(NuevoProductDto dto) {
        Optional<ProductUsuario> usuario = productusuarioDao.findByProduct(dto.getProductusuario());
        if(usuario.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        ProductUsuario productusuarioSave = ProductUsuario.builder()
                .productusuario(dto.getProductusuario())
                .password(password)
                .rol(dto.getRol())
                .build();
        return productusuarioDao.save(productusuarioSave);
    }

    public TokenDto login(ProductDto dto) {
        Optional<ProductUsuario> usuario = productusuarioDao.findByProduct(dto.getProductusuario());
        if(!usuario.isPresent())
            return null;
        if(passwordEncoder.matches(dto.getPassword(), usuario.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(usuario.get()));
        return null;
    }

    public TokenDto validate(String token, RequestDto dto) {
        if(!jwtProvider.validate(token, dto))
            return null;
        String productusuario = jwtProvider.getUserNameFromToken(token);
        if(!productusuarioDao.findByProduct(productusuario).isPresent())
            return null;
        return new TokenDto(token);
    }
}
