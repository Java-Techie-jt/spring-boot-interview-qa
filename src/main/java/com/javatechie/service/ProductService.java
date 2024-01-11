package com.javatechie.service;

import com.javatechie.annotation.LogPayloads;
import com.javatechie.annotation.TrackExecutionTime;
import com.javatechie.dto.Product;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    List<Product> productList = Stream.of(
            new Product("PTC49893", "Mobile", 9500, "SAMSUNG Galaxy F13 (Sunrise Copper, 64 GB)", "Electronics"),
            new Product("PTC25563", "Keyboard", 9500, "MAC Magic Keyboard", "Electronics"),
            new Product("PTC25372", "Books", 250, "It Ends With Us", "Education"),
            new Product("PTC49823", "Remote Control Toys", 699, "Wembley High Speed Mini 1:24 Scale Rechargeable Remote Control car with Lithium Battery", "Baby&Kids")
    ).collect(Collectors.toList());


    public List<Product> getProducts() {
        return productList;
    }

    @TrackExecutionTime
    @LogPayloads
    public List<Product> saveProduct(Product product) {
        boolean containsProductId = productList.stream()
                .map(Product::getId)
                .anyMatch(productId -> productId.equals(product.getId()));
        if (!containsProductId) {
            productList.add(product);
        } else {
            throw new RuntimeException("Product code already exist in system ! " + product.getId());
        }
        return productList;
    }

    public List<Product> getProductByType(String productType) {
        List<Product> products = productList.stream()
                .filter(product -> product.getProductType().equals(productType))
                .collect(Collectors.toList());

        return Optional.of(products)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new RuntimeException("Products not available for the type " + productType));

    }

    public String fetchLocation(boolean flag, String storeId) {

            if (flag) {
                //fetch from application DB
                throw new DataRetrievalFailureException("Store not available in system with storeId " + storeId);
            } else {
                //do rest api call to fetch store info by ID
                throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Rest client error occurred while fetching store information");
            }

    }


}
