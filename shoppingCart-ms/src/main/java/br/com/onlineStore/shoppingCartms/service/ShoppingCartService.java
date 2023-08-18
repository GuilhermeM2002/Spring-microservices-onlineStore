package br.com.onlineStore.shoppingCartms.service;

import br.com.onlineStore.shoppingCartms.DTO.DataShoppingCart;
import br.com.onlineStore.shoppingCartms.http.ProductClient;
import br.com.onlineStore.shoppingCartms.domain.ShoppingCart;
import br.com.onlineStore.shoppingCartms.repository.ShoppingCartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private ShoppingCartRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UpdateCartService updateCart;
    
    public DataShoppingCart persistProductCart(Long id){
        var product = productClient.getProduct(id);
        var productCart = mapper.map(product, ShoppingCart.class);
        repository.save(productCart);
        return mapper.map(product, DataShoppingCart.class);
    }

    public DataShoppingCart updateProductCart(DataShoppingCart dto, Long id){
        var shoppingCart = repository.getReferenceById(id);
        if(shoppingCart == null){
            throw new EntityNotFoundException();
        }
        updateCart.updateCart(dto, shoppingCart);
        return mapper.map(shoppingCart, DataShoppingCart.class);
    }

    public void deleteProductCart(Long id){
        repository.deleteById(id);
    }

    public Page<DataShoppingCart> allShoppingCart(Pageable pageable){
        return repository.findAll(pageable)
                .map(product -> mapper.map(product, DataShoppingCart.class));
    }
}
