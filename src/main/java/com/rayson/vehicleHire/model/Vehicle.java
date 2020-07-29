package com.rayson.vehicleHire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    @Id
    @Getter
    @Setter
    private String Id;

    @Indexed(unique=true)
    @Getter
    @Setter
    private int carNo;

    @Getter
    @Setter
    private String registrationNumber;

    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    private String make;

    @Getter
    @Setter
    private String model;

    @Getter
    @Setter
    private Boolean hired;

    @Getter
    @Setter
    private Customer customer;

    @Getter
    @Setter
    private String dateHired;

}
