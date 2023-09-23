package com.javatechie.di;

public class OrderInstanceFactory {

    public static OrderRepository getInstance() {
        return new OrderRepositoryImpl();
    }
}
