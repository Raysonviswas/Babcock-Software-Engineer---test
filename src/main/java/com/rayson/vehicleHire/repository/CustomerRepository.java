package com.rayson.vehicleHire.repository;

import com.rayson.vehicleHire.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}