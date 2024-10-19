package Uber.database;

import Uber.exceptions.NoCabsAvailableException;
import Uber.exceptions.TripNotFoundException;
import Uber.model.Cab;
import Uber.model.Location;
import Uber.model.Rider;
import Uber.model.Trip;
import Uber.strategies.CabMatchingStrategy;
import Uber.strategies.PricingStrategy;
import jdk.jshell.Snippet;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String , List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RideManager rideManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripManager(CabsManager cabsManager,
                       RideManager rideManager,
                       CabMatchingStrategy cabMatchingStrategy,
                       PricingStrategy pricingStrategy){
        this.cabsManager =cabsManager;
        this.rideManager = rideManager;
        this.cabMatchingStrategy =cabMatchingStrategy;
        this.pricingStrategy =pricingStrategy;
    }

    public void createTrip(@NonNull final Rider rider,
                           @NonNull final Location fromPoint,
                           @NonNull final Location toPoint){
        final List<Cab> closeByCabs = cabsManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        final  List<Cab> closeByAvailableCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());

        final Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider,closeByAvailableCabs,fromPoint,toPoint);
        if(selectedCab==null) {
            throw new NoCabsAvailableException();
        }

        final Double price =pricingStrategy.findPrice(fromPoint,toPoint);
        final Trip newTrip = new Trip(rider,selectedCab,price,fromPoint,toPoint);
        if(!trips.containsKey(rider.getId())){
            trips.put(rider.getId(),new ArrayList<>());
        }

        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }

    public List<Trip> tripHistory(@NonNull final Rider rider){
        return trips.get(rider.getId());
    }

    public void endTrip(@NonNull final Cab cab) {
        if(cab.getCurrentTrip()==null){
            throw new TripNotFoundException();
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
