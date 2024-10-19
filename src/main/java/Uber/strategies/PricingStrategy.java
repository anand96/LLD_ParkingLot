package Uber.strategies;

import Uber.model.Location;

public interface PricingStrategy {
    Double findPrice(Location fromPoint, Location toPoint);
}
