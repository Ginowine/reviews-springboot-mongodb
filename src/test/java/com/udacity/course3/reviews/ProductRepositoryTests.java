package com.udacity.course3.reviews;

import com.udacity.course3.reviews.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@DataMongoTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    private final static List<Double> PRODUCT_ID_LIST = Arrays.asList(1.0, 1.2);
    private static final Random RANDOM = new Random();

    @BeforeEach
    public void dataSetup(){

    }
}
