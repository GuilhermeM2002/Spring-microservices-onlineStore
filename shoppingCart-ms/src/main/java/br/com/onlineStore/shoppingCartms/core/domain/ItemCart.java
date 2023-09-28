package br.com.onlineStore.shoppingCartms.core.domain;

import br.com.onlineStore.shoppingCartms.application.dto.ItemCartDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "item")
@Table(name = "item")
public class ItemCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ShoppingCart shoppingCart;
    private Product product;
    @Column(name = "qt_product")
    private int quantityOfProduct;

    public void updateItemFromDto(ItemCartDto dto){
        this.product = dto.getProduct();
        this.quantityOfProduct = dto.getQuantity();
    }
}
