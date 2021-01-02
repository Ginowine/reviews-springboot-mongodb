package com.udacity.course3.reviews.controllertests;

import com.udacity.course3.reviews.controller.ProductsController;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repositories.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductsController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void getAllProducts() throws Exception{
        Product product1 = productRepository.save(new Product("1.0", "Jeans Jacket", 100.2));
        Product product2 = productRepository.save(new Product("2.0", "Refrigerator", 280.2));
        Product product3 = productRepository.save(new Product("3.0", "Sweat Pants", 156.2));

        List<Product> allProduct = Arrays.asList(product1, product2, product3);
        given(productRepository.findAll()).willReturn(allProduct);

        mvc.perform(get("/products")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].productId", is(product1.getProductId())))
                .andExpect((ResultMatcher) jsonPath("$[0].productName", is(product1.getProductName())));

    }
}