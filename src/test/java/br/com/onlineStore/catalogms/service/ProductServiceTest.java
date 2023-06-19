package br.com.onlineStore.catalogms.service;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import br.com.onlineStore.catalogms.domain.Product;
import br.com.onlineStore.catalogms.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;
    @Mock
    private ModelMapper mapper;
    @InjectMocks
    private ProductService productService;
    private DataProduct dto;
    private Product product;
    private Long id;
    @BeforeEach
    void setUp() {
        dto = mock(DataProduct.class);
        product = mock(Product.class);
        id = 1L;
    }
    @Test
    @DisplayName("Should persist product and return mapped DataProduct")
    void persistProduct() {
        when(mapper.map(dto, Product.class)).thenReturn(product);
        when(repository.save(product)).thenReturn(product);
        when(mapper.map(product, DataProduct.class)).thenReturn(dto);

        DataProduct result = productService.persistProduct(dto);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(dto, result),
                () -> verify(mapper).map(dto, Product.class),
                () -> verify(repository).save(product),
                () -> verify(mapper).map(product, DataProduct.class)
        );
    }
    @Test
    @DisplayName("Existing product should update product and return mapped DataProduct")
    void updateProductCase1() {
        when(repository.getReferenceById(id)).thenReturn(product);
        when(mapper.map(product, DataProduct.class)).thenReturn(dto);

        DataProduct result = productService.updateProduct(dto, id);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(dto, result),
                () -> verify(repository).getReferenceById(id),
                () -> verify(mapper).map(product, DataProduct.class)
        );
    }
    @Test
    @DisplayName("Non existing product should throw EntityNotFoundException")
    void updateProductCase2() {
        when(repository.getReferenceById(id)).thenReturn(null);

        assertThrows(EntityNotFoundException.class, () -> productService.updateProduct(new DataProduct(), id));
        verify(repository).getReferenceById(id);
    }
}