package com.cabbooking.uber.strategies;

import com.cabbooking.uber.models.Cab;
import com.cabbooking.uber.models.Location;
import com.cabbooking.uber.models.Rider;
import lombok.NonNull;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Cab matchCabToRider(
            @NonNull final Rider rider,
            @NonNull final List<Cab> candidateCabs,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.getFirst();
    }
}
