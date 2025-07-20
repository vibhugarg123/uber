package com.cabbooking.uber.strategies;

import com.cabbooking.uber.models.Cab;
import com.cabbooking.uber.models.Location;
import com.cabbooking.uber.models.Rider;

import java.util.List;

public interface CabMatchingStrategy {
    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
