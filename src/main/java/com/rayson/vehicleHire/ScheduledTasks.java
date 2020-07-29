package com.rayson.vehicleHire;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rayson.vehicleHire.model.*;
import com.rayson.vehicleHire.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    ScheduledTaskRepository scheduledTaskRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(initialDelay = 1000, fixedDelay=Long.MAX_VALUE)
    public void scheduleFixedRateWithInitialDelayTask() throws IOException {
        ScheduledTask scheduledTask;
        ObjectMapper objectMapper = new ObjectMapper();

        if (scheduledTaskRepository.findByOrderById().size() > 0) {

            scheduledTask = scheduledTaskRepository.findByOrderById().get(0);
        } else {

            scheduledTask = new ScheduledTask();
        }

        if(scheduledTask.getVehiclesPopulated() == null || !scheduledTask.getVehiclesPopulated()) {

            List<Vehicle> vehicles = objectMapper.readValue(new File("src/main/resources/static/vehicles.json"), new TypeReference<List<Vehicle>>(){});
            vehicleRepository.insert(vehicles);

            scheduledTask.setVehiclesPopulated(true);
        }

        if (scheduledTask.getCustomersPopulated() == null || !scheduledTask.getCustomersPopulated()) {

            List<Customer> customers = objectMapper.readValue(new File("src/main/resources/static/customers.json"), new TypeReference<List<Customer>>(){});
            customerRepository.insert(customers);

            scheduledTask.setCustomersPopulated(true);
        }

        scheduledTaskRepository.save(scheduledTask);
    }

}
