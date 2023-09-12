package br.com.onlineStore.catalogms.core.useCases;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.core.domain.Product;

public interface UpdateProductUseCase {
    public void updateProduct(Product product, ProductDto dto);
}
