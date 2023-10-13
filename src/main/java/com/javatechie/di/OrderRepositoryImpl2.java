package com.javatechie.di;

import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl2 implements OrderRepository{
    @Override
    public void saveOrder() {
        System.out.println("OrderRepositoryImpl2::saveOrder() method executed..");
    }
}
