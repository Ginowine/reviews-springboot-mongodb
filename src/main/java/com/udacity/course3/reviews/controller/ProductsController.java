package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product product1 = new Product();
        product1.setProductId(product.getProductId());
        product1.setProductName(product.getProductName());
        product1.setProductAmt(product.getProductAmt());

        List<Review> review = product.getReviews();
        product1.setReviews(review);

        productRepository.save(product1);
        return ResponseEntity.ok(product1);

    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        return ResponseEntity.of(productRepository.findById(id));

//        Optional<Product> productData = productRepository.findById(id);
//        if (productData.isPresent()){
//            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listProducts() {
        Iterable<Product> productIterable = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();
        for (Product product1 : productIterable){
            productList.add(product1);
        }
        return productList;
    }

    /**
     * select products by name.
     *
     * @return The list of products.
     */

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<Product> findByProductName(@PathVariable("productName") String productName){
        Iterable<Product> products = productRepository.findProductsByName(productName);
        List<Product> listOfProducts = new ArrayList<>();
        for (Product product : products){
            listOfProducts.add(product);
        }
        return listOfProducts;
    }
}