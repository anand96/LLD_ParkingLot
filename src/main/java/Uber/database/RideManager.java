package Uber.database;

import Uber.exceptions.RiderAlreadyExistsException;
import Uber.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RideManager {
    Map<String , Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider newRider){
        if(riders.containsKey(newRider.getId()))
        {
            throw new RiderAlreadyExistsException();
        }
        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(@NonNull final String riderId){
        if(!riders.containsKey(riderId)) {
            throw new RiderAlreadyExistsException();
        }
        return riders.get(riderId);
    }
}
