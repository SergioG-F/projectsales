package pe.com.nttdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.dto.NewProductDto;
import pe.com.nttdata.dto.ProductDto;
import pe.com.nttdata.dto.RequestProductDto;
import pe.com.nttdata.dto.TokenProductDto;
import pe.com.nttdata.model.Product;
import pe.com.nttdata.service.ProductService;

@RestController
@RequestMapping("api-projectsales/v1/autenticationproduct")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/loginProduct")
    public ResponseEntity<TokenProductDto> login(@RequestBody ProductDto productdto){
        TokenProductDto tokenproductDto = productService.login(productdto);
        if(tokenproductDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenproductDto);
    }

    @PostMapping("/validarProduct")
    public ResponseEntity<TokenProductDto> validate(@RequestParam String token, @RequestBody RequestProductDto productdto){
        TokenProductDto tokenproductDto = productService.validate(token, productdto);
        if(tokenproductDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenproductDto);
    }

    @PostMapping("/crearProduct")
    public ResponseEntity<Product> create(@RequestBody NewProductDto newproductdto){
        Product product = productService.save(newproductdto);
        if(product == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(product);
    }
}
