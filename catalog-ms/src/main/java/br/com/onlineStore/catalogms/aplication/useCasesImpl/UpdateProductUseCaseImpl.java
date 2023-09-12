package br.com.onlineStore.catalogms.aplication.useCasesImpl;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.core.domain.Product;
import br.com.onlineStore.catalogms.core.useCases.UpdateProductUseCase;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    @Override
    public void updateProduct(Product product, ProductDto dto) {
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setQuantity(dto.getQuantity());
        product.setCategory(dto.getCategory());
    }
}
