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

@DataMongoTest
public class ProductRepositoryTests {
    private static final Logger LOG = Logger.getLogger(ProductRepositoryTests.class.getName());
    @Autowired
    private ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void dataSetup(){
        product = new Product(1.0, "Sugar", 23.5);
        product = new Product(2.0, "Milk", 73.5);
        product = new Product(3.0, "Rice", 33.5);
        product = new Product(4.0, "Fish", 93.5);

        productRepository.save(product);
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
        Optional<Product> productList = productRepository.findById("1.0");
        assertThat(productList, hasSize(1));
        assertThat(productList.get().getProductId()).isNotNull();
    }
}
