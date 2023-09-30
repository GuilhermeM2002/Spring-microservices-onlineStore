package br.com.onlineStore.shoppingCartms.core.useCases;

import br.com.onlineStore.shoppingCartms.application.dto.ItemCartDto;
import br.com.onlineStore.shoppingCartms.core.domain.Product;
import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;

public interface GenerateItemCartUseCase {
    ItemCartDto generateItemCart(Long productId, int quantity);
}
