package br.com.onlineStore.shoppingCartms.adapters.repository;

import br.com.onlineStore.shoppingCartms.core.domain.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {
}
