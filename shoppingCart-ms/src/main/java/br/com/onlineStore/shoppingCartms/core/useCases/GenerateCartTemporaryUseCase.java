package br.com.onlineStore.shoppingCartms.core.useCases;

import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;

public interface GenerateCartTemporaryUseCase {
    ShoppingCart createCart();
    ShoppingCart generateToken();
}