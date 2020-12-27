package com.udacity.course3.reviews;

import com.udacity.course3.reviews.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
}
