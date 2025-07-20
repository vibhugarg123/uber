package com.cabbooking.uber.models;

import lombok.Data;

@Data
public class Cab {
    private String id;
    private String driverName;
    private Trip currentTrip;
    private Location currentLocation;
    private Boolean isAvailable;

    public Cab(String id, String driverName, Boolean isAvailable) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = isAvailable;
    }
}
