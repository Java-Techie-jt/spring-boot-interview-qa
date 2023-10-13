package com.javatechie.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanScopeTestService {

    public BeanScopeTestService() {
        System.out.println("BeanScopeTestService() instance created..");
    }
}
