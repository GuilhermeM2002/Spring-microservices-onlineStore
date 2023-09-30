package br.com.onlineStore.shoppingCartms.adapters.repository;

import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByToken(String token);
}
