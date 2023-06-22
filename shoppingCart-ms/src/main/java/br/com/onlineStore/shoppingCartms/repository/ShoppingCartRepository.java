package br.com.onlineStore.shoppingCartms.repository;

import br.com.onlineStore.shoppingCartms.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
