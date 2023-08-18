package br.com.onlineStore.shoppingCartms.http;

import br.com.onlineStore.shoppingCartms.DTO.DataShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("catalog-ms")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "product/{id}")
    DataShoppingCart getProduct(@PathVariable Long id);
}
