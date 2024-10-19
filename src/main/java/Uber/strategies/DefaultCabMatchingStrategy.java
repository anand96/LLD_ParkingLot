package Uber.strategies;

import Uber.model.Cab;
import Uber.model.Location;
import Uber.model.Rider;
import lombok.NonNull;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Cab matchCabToRider(
            @NonNull Rider rider,
            @NonNull List<Cab> candidateCabs,
            @NonNull Location fromPoint,
            @NonNull Location toPoint) {
        if(candidateCabs.isEmpty())
            return null;

        return candidateCabs.get(0);
    }
}
