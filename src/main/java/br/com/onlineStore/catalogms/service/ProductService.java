package br.com.onlineStore.catalogms.service;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import br.com.onlineStore.catalogms.domain.Product;
import br.com.onlineStore.catalogms.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;

    public DataProduct persistProduct(DataProduct dto){
        var product = mapper.map(dto, Product.class);
        var persistedProduct = repository.save(product);
        return mapper.map(persistedProduct, DataProduct.class);
    }

    public DataProduct updateProduct(DataProduct dto, Long code){
        var product = repository.getReferenceById(code);
        if (product == null){
            throw new EntityNotFoundException();
        }
        product.productUpdate(dto);
        return mapper.map(product, DataProduct.class) ;
    }

    public void deleteProduct(Long code){
        repository.deleteById(code);
    }

    public Page<DataProduct> findAllProduct(Pageable page){
        return repository.findAll(page)
                .map(product -> mapper.map(product, DataProduct.class));
    }

    public DataProduct findByCodeProduct(Long code){
        var product = repository.findById(code)
                .orElseThrow(() -> new EntityNotFoundException());
        return mapper.map(product, DataProduct.class);
    }
}
