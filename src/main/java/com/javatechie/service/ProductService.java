package com.javatechie.service;

import com.javatechie.annotation.LogPayloads;
import com.javatechie.annotation.TrackExecutionTime;
import com.javatechie.dto.Product;
import com.javatechie.exception.ProductNotFoundException;
import com.javatechie.handler.DuplicateProductException;
import com.javatechie.handler.ProductServiceException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

    //joinpoint
    //pointcut (com.javatechie.service.saveProduct.*())
    @TrackExecutionTime
    @LogPayloads
    public List<Product> saveProduct(Product product) {
        //TransactionAspect
        //loggingAspect
        //validationAspect
        //auditingAspect
        //notificationAspect
        boolean containsProductId = productList.stream()
                .map(Product::getId)
                .anyMatch(productId -> productId.equals(product.getId()));
        if (!containsProductId) {
            productList.add(product);
        } else {
            throw new DuplicateProductException("Product code already exist in system ! " + product.getId());
        }
        return productList;
    }

    //Before Advice
    public List<Product> getProductByType(String productType) {
        //Transaction
        //logging
        //validation
        //auditing
        //notification
        List<Product> products = productList.stream()
                .filter(product -> product.getProductType().equals(productType))
                .collect(Collectors.toList());

        return Optional.of(products)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ProductNotFoundException("Products not available for the type " + productType));

    }
    //After Advice -> consider Exception
    //After returning Advice -> No Exception
    //After throwing advice -> if any exception occurs
    //around advice -> Before + After returning

    public String fetchLocation(boolean flag, String storeId) {
        //Transaction
        //logging
        //validation
        //auditing
        //notification
        try {
            if (flag) {
                //fetch from application DB
                //logic
                throw new DataRetrievalFailureException("Store not available in system with storeId " + storeId);
            } else {
                //do rest api call to fetch store info by ID
                //logic
                throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Rest client error occurred while fetching store information");
            }
        } catch (Exception exception) {
            throw new ProductServiceException(exception.getMessage());
        }

    }


}
