package com.rayson.vehicleHire.controller;

import com.rayson.vehicleHire.model.Vehicle;
import com.rayson.vehicleHire.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles () {
        return vehicleService.getVehicles();
    }

    @GetMapping("/hireableVehicles")
    public List<Vehicle> getHireableVehicles () {
        return vehicleService.getVehiclesByHired(false);
    }

    @GetMapping("/vehicle/{id}/date1/{date1}/date2/{date2}")
    public String getHireRate (@PathVariable(value = "id") String id,
                               @PathVariable(value = "date1") String date1,
                               @PathVariable(value = "date2") String date2) throws ParseException {

        return vehicleService.getHireRate(id, date1, date2);
    }

    @PostMapping("/vehicle")
    public void addVehicle(@RequestBody Vehicle vehicle) {
         vehicleService.addVehicle(vehicle);
    }

}
