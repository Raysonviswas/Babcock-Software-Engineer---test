package com.rayson.vehicleHire.controller;

import com.rayson.vehicleHire.service.VehicleService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
class VehicleControllerTest {

    VehicleController vehicleController = new VehicleController();

    @Autowired
    @InjectMocks
    VehicleService vehicleService;


    @Before
    void init () {
        MockitoAnnotations.initMocks(this);

    }

/*    @Test
    void getVehiclesForHire() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("rego", Category.ESTATE, "make", "model", null);
        vehicles.add(vehicle);

        when(vehicleService.getVehiclesForHire())
                .thenReturn(vehicles);

        List<Vehicle> result = vehicleController.getVehiclesForHire();

        assertEquals(result.get(0).getClass(), Vehicle.class);
    }*/
}