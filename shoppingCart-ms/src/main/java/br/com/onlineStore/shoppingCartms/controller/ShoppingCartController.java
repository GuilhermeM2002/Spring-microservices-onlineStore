package br.com.onlineStore.shoppingCartms.controller;

import br.com.onlineStore.shoppingCartms.application.dto.ShoppingCartDto;
import br.com.onlineStore.shoppingCartms.infra.ShoppingCartRepositoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepositoryService service;
    @PostMapping("/{id}")
    public ResponseEntity persist(@PathVariable Long id, UriComponentsBuilder builder){
        var uri = builder.path("/shoppingCart/{id}").buildAndExpand(id).toUri();
        var cart = service.persistProductCart(id);
        return ResponseEntity.created(uri).body(cart);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody @Valid ShoppingCartDto dto, @PathVariable Long id){
        var cart = service.updateProductCart(dto, id);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteProductCart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<ShoppingCartDto> findAll(@PageableDefault(sort = "price") Pageable pageable){
        return service.allShoppingCart(pageable);
    }
}
