package pe.com.nttdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.nttdata.dao.IProductoDao;
import pe.com.nttdata.dto.NewProductDto;
import pe.com.nttdata.dto.ProductDto;
import pe.com.nttdata.dto.RequestProductDto;
import pe.com.nttdata.dto.TokenProductDto;
import pe.com.nttdata.model.Product;
import pe.com.nttdata.security.JwtProvider;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    IProductoDao productDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public Product save( NewProductDto newproductdto) {
        Optional<Product> product = productDao.findByProduct(newproductdto.getProductusuario());
        if(product.isPresent())
            return null;
        String password = passwordEncoder.encode(newproductdto.getPasswords());
        Product productSave = Product.builder()
                .productusuario(newproductdto.getProductusuario())
                .passwords(password)
                .roles(newproductdto.getRoles())
                .build();
        return productDao.save(productSave);
    }

    public TokenProductDto login(ProductDto productdto) {

        Optional<Product> product = productDao.findByProduct(productdto.getProductusuario());
        if(!product.isPresent())
            return null;
        if(passwordEncoder.matches(productdto.getPasswords(), product.get().getPasswords()))
            return new TokenProductDto(jwtProvider.createToken(product.get()));
        return null;
    }

    public TokenProductDto validate(String token, RequestProductDto requestproductdto) {
        if(!jwtProvider.validate(token, requestproductdto))
            return null;
        String productusuario = jwtProvider.getUserNameFromToken(token);
        if(!productDao.findByProduct(productusuario).isPresent())
            return null;
        return new TokenProductDto(token);
    }

}
