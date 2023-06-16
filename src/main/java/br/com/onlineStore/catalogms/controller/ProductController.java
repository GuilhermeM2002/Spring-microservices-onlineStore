package br.com.onlineStore.catalogms.controller;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import br.com.onlineStore.catalogms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity persist(@RequestBody @Valid DataProduct dto, UriComponentsBuilder builder){
        var product = service.persistProduct(dto);
        var uri = builder.path("product/{id}").buildAndExpand(product.getCodeProduct()).toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody @Valid DataProduct dto, @PathVariable Long id){
        var product = service.updateProduct(dto, id);
        return ResponseEntity.ok(product);
    }
}
