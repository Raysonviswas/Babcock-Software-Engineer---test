package com.rayson.vehicleHire.repository;

import com.rayson.vehicleHire.model.ScheduledTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduledTaskRepository extends MongoRepository<ScheduledTask, String> {

    List<ScheduledTask> findByOrderById();

}
