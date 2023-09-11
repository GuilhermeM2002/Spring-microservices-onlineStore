package br.com.onlineStore.catalogms.DTO;

import br.com.onlineStore.catalogms.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataProduct {
    private Long codeProduct;
    private String name;
    private double price;
    private String description;
    private int quantity;
    private Category category;
}
