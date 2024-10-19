package UBER_KEERTI.manager;


import UBER_KEERTI.model.*;
import UBER_KEERTI.strategies.DriverMatchingStrategy;
import UBER_KEERTI.strategies.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

class TripMgr {
    private static TripMgr tripMgrInstance = null;
    private Map<Integer, Trip> tripsInfo;
    private Map<Integer, TripMetaData> tripsMetaDataInfo;
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;

    private TripMgr() {
        this.tripsInfo = new HashMap<>();
        this.tripsMetaDataInfo = new HashMap<>();
        this.riderMgr = RiderMgr.getRiderMgr();
        this.driverMgr = DriverMgr.getDriverMgr();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            tripMgrInstance = new TripMgr();
        }
        return tripMgrInstance;
    }

    public Map<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }

    public void createTrip(Rider rider, Driver driver, Location srcLoc, Location dstLoc, double price,
                           PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        int tripId = tripsInfo.size() + 1; // Auto-increment tripId
        Trip trip = new Trip(driver, srcLoc, dstLoc, tripId, price, pricingStrategy, driverMatchingStrategy);
        tripsInfo.put(tripId, trip);
    }
}

