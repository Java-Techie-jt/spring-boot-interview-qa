package com.javatechie.controller;

import com.javatechie.dto.Product;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/search/{productType}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable String productType) {
        return ResponseEntity.ok(service.getProductByType(productType));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductUsingParam(@RequestParam(value = "productType", required = false) String productType) {
        return ResponseEntity.ok(productType != null
                ? service.getProductByType(productType)
                : service.getProducts());
    }
}
