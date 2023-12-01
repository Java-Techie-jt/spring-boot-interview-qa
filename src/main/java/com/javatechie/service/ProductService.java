package com.javatechie.service;

import com.javatechie.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    List<Product> productList = Stream.of(
            new Product("Mobile", 9500, "SAMSUNG Galaxy F13 (Sunrise Copper, 64 GB)", "Electronics"),
            new Product("Keyboard", 9500, "MAC Magic Keyboard", "Electronics"),
            new Product("Books", 250, "It Ends With Us", "Education"),
            new Product("Remote Control Toys", 699, "Wembley High Speed Mini 1:24 Scale Rechargeable Remote Control car with Lithium Battery", "Baby&Kids")
    ).collect(Collectors.toList());


    public List<Product> getProducts() {
        return productList;
    }

    public List<Product> getProductByType(String productType) {
        return productList.stream()
                .filter(product -> product.getProductType().equals(productType))
                .collect(Collectors.toList());
    }
}
