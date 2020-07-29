package com.rayson.vehicleHire.controller;

import com.rayson.vehicleHire.model.Customer;
import com.rayson.vehicleHire.model.Vehicle;
import com.rayson.vehicleHire.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers () {
        return customerService.getCustomers();
    }


    @PostMapping("/customer")
    public void addCustomer (@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

}
