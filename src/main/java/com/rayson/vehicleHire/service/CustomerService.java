package com.rayson.vehicleHire.service;

import com.rayson.vehicleHire.model.Customer;
import com.rayson.vehicleHire.model.CustomerType;
import com.rayson.vehicleHire.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers () {
        return customerRepository.findAll();
    }

    public void addCustomer (Customer customer) { customerRepository.save(customer); }

}
