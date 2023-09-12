package br.com.onlineStore.catalogms.core.useCases;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;

public interface PriceProductUseCase {
    public ProductDto persistProduct(ProductDto dto);
}
