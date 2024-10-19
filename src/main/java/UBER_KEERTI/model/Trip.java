package UBER_KEERTI.model;

import UBER_KEERTI.strategies.DriverMatchingStrategy;
import UBER_KEERTI.model.Location;
import UBER_KEERTI.strategies.PricingStrategy;

public class Trip {
    private Rider rider;
    private Driver driver;
    private Location srcLoc;
    private Location destLoc;
    private TripStatus status;
    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Driver driver, Location srcLoc, Location destLoc, int tripId, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.driver = driver;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.status = TripStatus.PENDING; // Assume default stat
        this.tripId = tripId;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
    }

    public int getTripId(){
        return tripId;
    }

    public void displayTripDetails(){

    }
}
