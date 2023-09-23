package com.javatechie.di;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void saveOrder() {
        System.out.println("OrderRepository::saveOrder() method executed..");
    }
}
