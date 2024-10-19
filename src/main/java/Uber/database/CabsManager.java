package Uber.database;

import Uber.exceptions.CabAlreadyExistsException;
import Uber.exceptions.CabNotFoundException;
import Uber.model.Cab;
import Uber.model.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {
    Map<String , Cab> cabs = new HashMap<>();

    public void createCab(@NonNull final Cab newCab)
    {
        if(cabs.containsKey(newCab.getId())){
            throw new CabAlreadyExistsException();
        }

        cabs.put(newCab.getId(), newCab);
    }

    public Cab getCab(@NonNull final String cabId){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabAvailablity(@NonNull final String cabId,@NonNull final Boolean newAvailablity){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setIsAvailable(newAvailablity);
    }

    public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }
}
