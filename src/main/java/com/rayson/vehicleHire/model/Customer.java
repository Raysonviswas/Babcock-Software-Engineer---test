package com.rayson.vehicleHire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @Getter
    @Setter
    private String Id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private CustomerType customerType;

    public Customer(String name, String customerType) {
        this.setName(name);
        this.setCustomerType(CustomerType.valueOf(customerType.toUpperCase()));
    }

}
