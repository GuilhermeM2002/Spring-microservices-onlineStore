package br.com.onlineStore.shoppingCartms.infra.http;

import br.com.onlineStore.shoppingCartms.application.dto.ShoppingCartDto;
import br.com.onlineStore.shoppingCartms.core.domain.ProductCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("catalog-ms")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "product/{id}")
    ProductCart getProduct(@PathVariable Long id);
}
