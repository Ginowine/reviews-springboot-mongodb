package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repositories.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class ProductRepositoryTests {
    private static final Logger LOG = Logger.getLogger(ProductRepositoryTests.class.getName());
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createProductTest(){
        Product product = productRepository.save(new Product("1.0", "Snickers", 243.45));
        assertThat(product).hasFieldOrPropertyWithValue("productId", "1.0");
        assertThat(product).hasFieldOrPropertyWithValue("productName", "Snickers");
        assertThat(product).hasFieldOrPropertyWithValue("productAmt", 243.45);
    }

    @Test
    public void getAllProduct(){
        List<Product> allProduct = productRepository.findAll();
        LOG.info("There are " + allProduct.size() + " product(s) in database");
        assertThat(allProduct.size(), equalTo(4));
        assertNotNull(allProduct);
    }

    @Test
    public void findById(){
        Product productList = productRepository.findById(product.getProductId()).get();
        assertThat(productList).isEqualTo(

                hasSize(1));
        assertThat(productList.getProductId()).isNotNull();
    }
}
