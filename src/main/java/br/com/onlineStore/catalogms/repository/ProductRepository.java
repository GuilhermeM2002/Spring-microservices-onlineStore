package br.com.onlineStore.catalogms.repository;

import br.com.onlineStore.catalogms.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
