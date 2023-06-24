package br.com.onlineStore.shoppingCartms.service;

import br.com.onlineStore.shoppingCartms.DTO.DataShoppingCart;
import br.com.onlineStore.shoppingCartms.domain.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartService {
    public void updateCart(DataShoppingCart dto, ShoppingCart cart){
        cart.setName(dto.getName());
        cart.setPrice(dto.getPrice());
        cart.setQuantity(dto.getQuantity());
    }
}
