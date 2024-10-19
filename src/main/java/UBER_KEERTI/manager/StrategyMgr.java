package UBER_KEERTI.manager;


import UBER_KEERTI.model.TripMetaData;
import UBER_KEERTI.strategies.DriverMatchingStrategy;
import UBER_KEERTI.strategies.LeastTimeBasedMatchingStrategy;
import UBER_KEERTI.strategies.RatingBasedPricingStrategy;
import UBER_KEERTI.strategies.PricingStrategy;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;

    private StrategyMgr(){
    }

    public static StrategyMgr getStrategyMgr(){
        if(strategyMgrInstance == null){
            strategyMgrInstance = new StrategyMgr();
        }
        return strategyMgrInstance;
    }


    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        // Determine the pricing strategy based on metadata
        return new RatingBasedPricingStrategy(); // Dummy strategy
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        // Determine the driver matching strategy based on metadata
        return new LeastTimeBasedMatchingStrategy(); // Dummy strategy
    }

}
