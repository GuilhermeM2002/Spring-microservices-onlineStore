package br.com.onlineStore.catalogms.service;

import br.com.onlineStore.catalogms.DTO.DataProduct;
import br.com.onlineStore.catalogms.domain.Category;
import br.com.onlineStore.catalogms.domain.Product;
import br.com.onlineStore.catalogms.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProductServiceTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private JacksonTester<DataProduct> jacksonTester;

    @Test
    @DisplayName("Return http code 400 when the information is invalid")
    void persistProduct400() throws Exception {
        var response = mvc.perform(post("/product")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Return http code 201 when the information is valid")
    void persistProduct201() throws Exception {
        var product = new DataProduct(
                1L,
                "Smartphone",
                5000,
                "Whatever",
                Category.ELECTRONIC
        );
        when(repository.save(any())).thenReturn(mapper.map(product, Product.class));

        var response = mvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonTester.write(product).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jacksonTester.write(product).getJson());
    }
}