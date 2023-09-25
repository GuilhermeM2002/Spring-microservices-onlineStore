package br.com.onlineStore.shoppingCartms.adapters.repository;

import br.com.onlineStore.shoppingCartms.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
