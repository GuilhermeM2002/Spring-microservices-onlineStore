package br.com.onlineStore.shoppingCartms.core.useCases;

import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;

public interface FindCartUsingTemporaryTokenUseCase {
    ShoppingCart findCartByToken(String token);
}