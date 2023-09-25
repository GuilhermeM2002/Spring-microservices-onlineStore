package br.com.onlineStore.shoppingCartms.infra;

import br.com.onlineStore.shoppingCartms.adapters.repository.ItemCartRepository;
import br.com.onlineStore.shoppingCartms.application.dto.ItemCartDto;
import br.com.onlineStore.shoppingCartms.application.useCasesImpl.UpdateCartUseCaseImpl;
import br.com.onlineStore.shoppingCartms.core.exception.ProductNotFoundException;
import br.com.onlineStore.shoppingCartms.infra.http.ProductClient;
import br.com.onlineStore.shoppingCartms.core.domain.ShoppingCart;
import br.com.onlineStore.shoppingCartms.adapters.repository.ShoppingCartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartRepositoryService {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private ItemCartRepository itemCartRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UpdateCartUseCaseImpl updateCart;
    
    public ItemCartDto persistProductCart(Long id){
        var product = productClient.getProduct(id);

        var productCart = mapper.map(product, ShoppingCart.class);
        itemCartRepository.save(productCart);

        return mapper.map(product, ItemCartDto.class);
    }

    public ItemCartDto updateItemCart(ItemCartDto dto, Long id){
        var itemCart = itemCartRepository.getReferenceById(id);
        if(itemCart == null){
            throw new ProductNotFoundException();
        }
        updateCart.updateCart(dto, itemCart);
        return mapper.map(itemCart, ItemCartDto.class);
    }

    public void deleteProductCart(Long id){
        itemCartRepository.deleteById(id);
    }

    public Page<ItemCartDto> allShoppingCart(Pageable pageable){
        return itemCartRepository.findAll(pageable)
                .map(product -> mapper.map(product, ItemCartDto.class));
    }
}
