package br.com.onlineStore.catalogms.adapters.controller;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.aplication.useCasesImpl.PersistProductUseCaseImpl;
import br.com.onlineStore.catalogms.infra.exception.PriceInvalidException;
import br.com.onlineStore.catalogms.infra.impl.ProductRepositoryImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductRepositoryImpl service;
    @Autowired
    private PersistProductUseCaseImpl persistProduct;
    @PostMapping
    public ResponseEntity persist(@RequestBody @Valid ProductDto dto, UriComponentsBuilder builder) throws PriceInvalidException {
        var product = persistProduct.persistProduct(dto);
        var uri = builder.path("product/{code}").buildAndExpand(product.getCodeProduct()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping("{code}")
    public ResponseEntity update(@RequestBody @Valid ProductDto dto, @PathVariable Long code){
        var product = service.updateProduct(dto, code);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{code}")
    public ResponseEntity delete(@PathVariable Long code){
        service.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<ProductDto> getAll(@PageableDefault(size = 20, sort = "name") Pageable pageable){
        return service.findAllProduct(pageable);
    }

    @GetMapping("{code}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long code){
        var product = service.findByCodeProduct(code);
        return ResponseEntity.ok(product);
    }
}
