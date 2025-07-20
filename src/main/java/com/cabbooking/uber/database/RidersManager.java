package com.cabbooking.uber.database;

import com.cabbooking.uber.exceptions.RiderAlreadyExistsException;
import com.cabbooking.uber.exceptions.RiderNotFoundException;
import com.cabbooking.uber.models.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider newRider) {
        if (riders.containsKey(newRider.getId())) {
            throw new RiderAlreadyExistsException();
        }

        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}
