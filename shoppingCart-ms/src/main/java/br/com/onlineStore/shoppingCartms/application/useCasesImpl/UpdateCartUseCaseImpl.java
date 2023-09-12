package br.com.onlineStore.shoppingCartms.application.useCasesImpl;

import br.com.onlineStore.shoppingCartms.application.dto.DataShoppingCart;
import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;
import br.com.onlineStore.shoppingCartms.core.useCases.UpdateCartUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartUseCaseImpl implements UpdateCartUseCase {
    public void updateCart(DataShoppingCart dto, ShoppingCart cart){
        cart.setName(dto.getName());
        cart.setPrice(dto.getPrice());
        cart.setQuantity(dto.getQuantity());
    }
}
