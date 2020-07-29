package com.rayson.vehicleHire.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
public class ScheduledTask {

    @Id
    @Getter
    @Setter
    String id;

    @Getter
    @Setter
    Boolean vehiclesPopulated;

    @Getter
    @Setter
    Boolean customersPopulated;

}
