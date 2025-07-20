package com.cabbooking.uber.models;

import lombok.Data;
import lombok.NonNull;

import static com.cabbooking.uber.models.TripStatus.FINISHED;
import static com.cabbooking.uber.models.TripStatus.IN_PROGRESS;

@Data
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(
            @NonNull final Rider rider,
            @NonNull final Cab cab,
            @NonNull final Double price,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.tripStatus = IN_PROGRESS;
    }

    public void endTrip() {
        this.tripStatus = FINISHED;
    }
}
