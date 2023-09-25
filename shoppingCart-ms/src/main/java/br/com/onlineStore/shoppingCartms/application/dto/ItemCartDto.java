package br.com.onlineStore.shoppingCartms.application.dto;

import br.com.onlineStore.shoppingCartms.core.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCartDto {
    private Product product;
    private int quantity;
}
