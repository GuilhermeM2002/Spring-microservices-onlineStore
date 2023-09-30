package br.com.onlineStore.shoppingCartms.application.useCasesImpl;

import br.com.onlineStore.shoppingCartms.adapters.repository.ProductRepository;
import br.com.onlineStore.shoppingCartms.application.dto.ProductDto;
import br.com.onlineStore.shoppingCartms.core.useCases.SaveProductUseCase;
import br.com.onlineStore.shoppingCartms.infra.http.ProductClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveProductUseCaseImpl implements SaveProductUseCase {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public ProductDto saveProduct(Long productId) {
        var product = productClient.getProduct(productId);
        productRepository.save(product);

        return mapper.map(product, ProductDto.class);
    }
}
