package br.com.onlineStore.shoppingCartms.core.useCases;

import br.com.onlineStore.shoppingCartms.application.dto.ShoppingCartDto;
import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;

public interface UpdateCartUseCase {
    public void updateCart(ShoppingCartDto dto, ShoppingCart cart);
}
