package com.rayson.vehicleHire.service;

import com.rayson.vehicleHire.model.Vehicle;
import com.rayson.vehicleHire.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private Environment env;

    public List<Vehicle> getVehicles () {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getVehiclesByHired (Boolean bool) { return vehicleRepository.findByHired(bool); }

    public String getHireRate (String id, String date1, String date2) throws ParseException {
        Vehicle vehicle = vehicleRepository.findByCarNo(Integer.parseInt(id)).orElseThrow();

        long pricePerDayInt = vehicle.getCategory().getRate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date sDate1 = dateFormat.parse(date1);
        Date sDate2 = dateFormat.parse(date2);

        long diffInMillis = Math.abs(sDate2.getTime() - sDate1.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long totalPrice = pricePerDayInt * days;
        return "Price for " + days + " days is £" + String.valueOf(totalPrice) + ",\n" +
                "At £" + pricePerDayInt + " a day.";
    }

    public void addVehicle (Vehicle vehicle) {
        vehicle.setHired(false);
        vehicleRepository.save(vehicle);
    }
}