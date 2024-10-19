package UBER_KEERTI.strategies;

import UBER_KEERTI.model.TripMetaData;

public class RatingBasedPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(TripMetaData tripMetaData) {
        return 150.0;
    }
}
