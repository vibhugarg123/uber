package com.cabbooking.uber.strategies;

import com.cabbooking.uber.models.Location;

public interface PricingStrategy {
    Double findPrice(Location fromPoint, Location toPoint);
}
