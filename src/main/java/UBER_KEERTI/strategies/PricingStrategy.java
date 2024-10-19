package UBER_KEERTI.strategies;

import UBER_KEERTI.model.TripMetaData;
import Uber.model.Location;


public interface PricingStrategy {
    Double calculatePrice(TripMetaData tripMetaData);
}
