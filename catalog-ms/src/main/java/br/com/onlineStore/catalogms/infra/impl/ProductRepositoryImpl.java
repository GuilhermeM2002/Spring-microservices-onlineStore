package br.com.onlineStore.catalogms.infra.impl;

import br.com.onlineStore.catalogms.aplication.dto.ProductDto;
import br.com.onlineStore.catalogms.aplication.useCasesImpl.UpdateProductUseCaseImpl;
import br.com.onlineStore.catalogms.core.domain.Product;
import br.com.onlineStore.catalogms.adapters.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductRepositoryImpl {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UpdateProductUseCaseImpl update;

    public ProductDto persistProduct(ProductDto dto){
        var product = mapper.map(dto, Product.class);
        var persistedProduct = repository.save(product);
        return mapper.map(persistedProduct, ProductDto.class);
    }

    public ProductDto updateProduct(ProductDto dto, Long code){
        var product = repository.getReferenceById(code);
        if (product == null){
            throw new EntityNotFoundException();
        }
        update.updateProduct(product, dto);
        return mapper.map(product, ProductDto.class);
    }

    public void deleteProduct(Long code){
        repository.deleteById(code);
    }

    public Page<ProductDto> findAllProduct(Pageable pageable){
        return repository.findAll(pageable)
                .map(product -> mapper.map(product, ProductDto.class));
    }

    public ProductDto findByCodeProduct(Long code){
        var product = repository.findById(code)
                .orElseThrow(() -> new EntityNotFoundException());
        return mapper.map(product, ProductDto.class);
    }
}
