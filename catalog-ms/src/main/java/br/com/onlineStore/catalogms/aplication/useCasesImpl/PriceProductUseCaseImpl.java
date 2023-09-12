package br.com.onlineStore.catalogms.aplication.useCasesImpl;

import br.com.onlineStore.catalogms.adapters.repository.ProductRepository;
import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.core.useCases.PriceProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceProductUseCaseImpl implements PriceProductUseCase {
    @Autowired
    private ProductRepository repository;
    @Override
    public ProductDto persistProduct(ProductDto dto) {
        if (dto.getPrice() <= 0){
            throw new RuntimeException();
        }

    }
}
