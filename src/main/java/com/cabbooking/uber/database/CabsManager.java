package com.cabbooking.uber.database;

import com.cabbooking.uber.exceptions.CabAlreadyExistsException;
import com.cabbooking.uber.exceptions.CabNotFoundException;
import com.cabbooking.uber.models.Cab;
import com.cabbooking.uber.models.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CabsManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(@NonNull final Cab newCab) {
        if (cabs.containsKey(newCab.getId())) {
            throw new CabAlreadyExistsException();
        }

        cabs.put(newCab.getId(), newCab);
    }

    public Cab getCab(@NonNull final String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabAvailability(
            @NonNull final String cabId, @NonNull final Boolean newAvailability) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setIsAvailable(newAvailability);
    }

    public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            // TODO: Use epsilon comparison because of double
            if (cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }
}
