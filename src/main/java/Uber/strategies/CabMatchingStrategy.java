package Uber.strategies;

import Uber.model.Cab;
import Uber.model.Location;
import Uber.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {
    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
