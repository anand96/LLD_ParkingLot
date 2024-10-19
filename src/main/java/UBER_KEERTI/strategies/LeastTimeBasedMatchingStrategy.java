package UBER_KEERTI.strategies;

import UBER_KEERTI.model.Driver;
import UBER_KEERTI.model.TripMetaData;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        return new Driver("John", 4.5);
    }
}
