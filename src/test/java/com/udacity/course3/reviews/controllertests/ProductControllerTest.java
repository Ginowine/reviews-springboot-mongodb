package com.udacity.course3.reviews.controllertests;

import com.udacity.course3.reviews.controller.ProductsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {ProductsController.class})
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;
}