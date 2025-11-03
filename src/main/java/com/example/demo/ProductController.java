package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
        return product;
    }
}

