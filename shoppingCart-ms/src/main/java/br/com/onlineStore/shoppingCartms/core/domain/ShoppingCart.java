package br.com.onlineStore.shoppingCartms.core.domain;

import br.com.onlineStore.shoppingCartms.application.dto.DataShoppingCart;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "shopping_cart")
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int quantity;

    public void updateShoppingCart(DataShoppingCart dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
}
