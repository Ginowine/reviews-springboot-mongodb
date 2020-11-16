package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
