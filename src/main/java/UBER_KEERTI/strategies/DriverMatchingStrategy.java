package UBER_KEERTI.strategies;

import UBER_KEERTI.model.Driver;
import UBER_KEERTI.model.TripMetaData;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData tripMetaData);
}
