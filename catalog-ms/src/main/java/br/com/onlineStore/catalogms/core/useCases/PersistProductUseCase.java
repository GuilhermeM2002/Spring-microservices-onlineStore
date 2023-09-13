package br.com.onlineStore.catalogms.core.useCases;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.core.exception.PriceInvalidException;

public interface PersistProductUseCase {
    public ProductDto persistProduct(ProductDto dto) throws PriceInvalidException;
}
