package br.com.onlineStore.catalogms.aplication.dto;

import br.com.onlineStore.catalogms.core.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ProductDto(Long codeProduct,
        String name,
        double price,
        String description,
        int quantity,
        Category category) { }
