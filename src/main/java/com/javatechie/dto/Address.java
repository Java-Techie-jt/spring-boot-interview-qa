
package com.javatechie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;

}
