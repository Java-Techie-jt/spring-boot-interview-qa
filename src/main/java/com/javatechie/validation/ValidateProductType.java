package com.javatechie.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductTypeValidator.class)
public @interface ValidateProductType {

    public String message() default "Invalid productType: It should be either Electronics OR Education OR Baby&Kids";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}