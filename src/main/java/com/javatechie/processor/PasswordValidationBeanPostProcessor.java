package com.javatechie.processor;

import com.javatechie.common.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof User user) {
//            if (!isValidPassword(user.getPassword())) {
//                throw new IllegalArgumentException("Invalid password for user: " + user.getUsername());
//            }
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private boolean isValidPassword(String password) {
        // Implement your password validation logic here
        // For example, check length, special characters, etc.
        return password.length() >= 8 && password.matches(".*[@#$%!].*");
    }
}
