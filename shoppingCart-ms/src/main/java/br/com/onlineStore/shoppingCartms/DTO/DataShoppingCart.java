package br.com.onlineStore.shoppingCartms.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataShoppingCart {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
