package br.com.onlineStore.catalogms.domain;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codeProduct")
@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_product")
    private Long codeProduct;
    @NotBlank
    @Size(max = 40)
    private String name;
    @NotBlank
    private double price;
    @NotBlank
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    public void productUpdate(DataProduct dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
        this.category = dto.getCategory();
    }
}
