package br.com.onlineStore.shoppingCartms.core.useCases;

import br.com.onlineStore.shoppingCartms.application.dto.DataShoppingCart;
import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;

public interface UpdateCartUseCase {
    public void updateCart(DataShoppingCart dto, ShoppingCart cart);
}
