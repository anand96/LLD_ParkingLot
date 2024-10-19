package UBER_KEERTI.model;

public class Driver {
    private String name;
    private boolean avail;
    private double rating;

    public Driver(String name, double rating) {
        this.name = name;
        this.rating = rating;
        this.avail = true;
    }

    public String getDriverName() {
        return name;
    }

    public boolean isAvailable() {
        return avail;
    }

    public void updateAvailability(boolean avail) {
        this.avail = avail;
    }

    public double getRating() {
        return rating;
    }
}

