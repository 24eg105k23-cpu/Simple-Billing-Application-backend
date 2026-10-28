package com.Billing_Application.billing_application;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }
    

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }


    @PostMapping
    public String addProduct(@RequestBody Product product) {

        if (product.getName() == null ||
            product.getName().trim().isEmpty()) {
            return "Product name is required";
        }

        if (product.getPrice() < 0) {
            return "Price cannot be negative";
        }

        product.setName(product.getName().trim());
        repository.save(product);

        return "Product added successfully";

    }
}
