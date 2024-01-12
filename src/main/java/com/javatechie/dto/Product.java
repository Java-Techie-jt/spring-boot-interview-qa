package com.javatechie.dto;

import com.javatechie.validation.ValidateProductType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotNull(message = "id shouldn't be null")
    @NotEmpty(message = "id shouldn't be empty")
    private String id;
    @NotBlank(message = "name shouldn't be null or empty")
    private String name;
    @Min(value = 499,message = "price shouldn't be less than 499")
    @Max(value = 100000,message = "price shouldn't be exceed more than 100000")
    private double price;
    @NotBlank(message = "model shouldn't be null or empty")
//    @Pattern(regexp = "[A-Za-z0-9]+")
    private String model;
    @NotBlank(message = "productType shouldn't be null or empty")
    @ValidateProductType
    private String productType;

//    @Email
//    private String emailId;
//
//    @AssertFalse
//    @AssertTrue
//    private boolean isActive;
//
//    @Future
//    @Past
//    private Date birthDate;

}
