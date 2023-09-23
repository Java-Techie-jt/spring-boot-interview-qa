package com.javatechie.di;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void saveOrder() {
        System.out.println("OrderRepository::saveOrder() method executed..");
    }
}
