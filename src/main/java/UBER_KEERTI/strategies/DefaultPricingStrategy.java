package UBER_KEERTI.strategies;

import UBER_KEERTI.model.TripMetaData;

// Default pricing strategy implementation
class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(TripMetaData tripMetaData) {
        return 100.0;
    }
}
