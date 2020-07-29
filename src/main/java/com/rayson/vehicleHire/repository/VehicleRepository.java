package com.rayson.vehicleHire.repository;

import com.rayson.vehicleHire.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    public List<Vehicle> findByHired(Boolean bool);

    public Optional<Vehicle> findByCarNo(int carNo);
}
