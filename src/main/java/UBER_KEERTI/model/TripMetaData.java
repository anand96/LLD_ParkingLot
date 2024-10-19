package UBER_KEERTI.model;

import Uber.model.Location;

public class TripMetaData {
    private double riderRating;
    private double driverRating;
    private Location srcLoc;
    private Location dstLoc;

    public TripMetaData(Location srcLoc,Location dstLoc,double riderRating, double driverRating){
        this.riderRating = riderRating;
        this.driverRating = driverRating;
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
    }

    public double getRiderRating(){
        return riderRating;
    }

    public double getDriverRating (){
        return driverRating;
    }

    public void setDriverRating(double driverRating){
        this.driverRating =driverRating;
    }
}
