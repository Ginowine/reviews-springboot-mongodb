package com.udacity.course3.reviews.repositorytests;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@DataMongoTest
public class ProductRepositoryTests {
    private static final Logger LOG = Logger.getLogger(ProductRepositoryTests.class.getName());
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Before
    public void setUp() throws Exception {
        Comment comment = new Comment();
        comment.se

        Review review = new Review();
        review.setReviewerName("Gino Winw");
        review.setReviewerTitle("Mr");
        review.setReviewerDescription("Product is great");
        review.setCreatedDate("23/12/02");
        review.se

        Product product1 = new Product();
        product1.setProductId("1.0");
        product1.setProductName("Laptop");
        product1.setProductAmt(23.5);

        Product product2 = new Product();
        product2.setProductId("2.0");
        product2.setProductName("Gas");
        product2.setProductAmt(65.5);

        Product product3 = new Product();
        product3.setProductId("3.0");
        product3.setProductName("Fridge");
        product3.setProductAmt(84.5);

        assertNull(product1.getProductId());
        assertNull(product2.getProductId());
        assertNull(product3.getProductId());

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);

        assertNotNull(product1.getProductId());
        assertNotNull(product2.getProductId());
        assertNotNull(product3.getProductId());


    }

    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setProductId("1.0");
        product.setProductName("Laptop");
        product.setProductAmt(23.5);
        //product.se
        Review review = new Review();
        reviewRepository.save(review);
        product.setReviews(review);
        productRepository.save(product);

        assertThat(product).hasFieldOrPropertyWithValue("productId", "1.0");
        assertThat(product).hasFieldOrPropertyWithValue("productName", "Laptop");
        assertThat(product).hasFieldOrPropertyWithValue("productAmt", 23.5);
    }

    @Test
    public void getAllProduct(){
        Product product1 = productRepository.save(new Product("1.0", "Jeans Jacket", 100.2));
        Product product2 = productRepository.save(new Product("2.0", "Refrigerator", 280.2));
        Product product3 = productRepository.save(new Product("3.0", "Sweat Pants", 156.2));

        List<Product> allProduct = productRepository.findAll();
        LOG.info("There are " + allProduct.size() + " product(s) in database");
        assertThat(allProduct.size(), equalTo(3));
        assertThat(allProduct).contains(product1, product2, product3);
        assertNotNull(allProduct);
    }

    @Test
    public void findById(){
        Product product1 = productRepository.save(new Product("1.0", "Jeans Jacket", 100.2));
        Product product2 = productRepository.save(new Product("2.0", "Face Cap", 20.2));

        Product product = productRepository.findById(product2.getProductId()).get();
        assertThat(product).isEqualTo(product2);
        assertThat(product.getProductId()).isNotNull();
        assertThat(product.getProductId()).contains("2.0");
    }

    @Test
    public void findProductByName(){
        Product product1 = productRepository.save(new Product("1.0", "Jeans Jacket", 100.2));
        Product product2 = productRepository.save(new Product("2.0", "Cooker", 150.2));
        Product product3 = productRepository.save(new Product("3.0", "Cooker Bar", 118.2));

        List<Product> productList = productRepository.findProductsByName("Cooker");
        assertThat(productList).hasSize(2);
        assertThat(productList).contains(product2, product3);
    }
}
