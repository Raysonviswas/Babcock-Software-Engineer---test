package com.rayson.vehicleHire.model;

import lombok.Getter;

public enum Category {
    SMALL(25),
    ESTATE(35),
    VAN(50);

    @Getter
    private int rate;

    private Category(int rate) {
            this.rate = rate;
    }

}
