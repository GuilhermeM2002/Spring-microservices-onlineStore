package br.com.onlineStore.catalogms.service;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import br.com.onlineStore.catalogms.domain.Product;
import br.com.onlineStore.catalogms.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;

    public DataProduct persistProduct(DataProduct dto){
        var product = mapper.map(dto, Product.class);
        repository.save(product);

        return mapper.map(product, DataProduct.class);
    }

    public DataProduct updateProduct(DataProduct dto, Long id){
        var product = repository.getReferenceById(id);

        if (product == null){
            throw new EntityNotFoundException();
        }
        product.productUpdate(dto);

        return mapper.map(product, DataProduct.class) ;
    }
}
