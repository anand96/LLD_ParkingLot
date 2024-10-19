package UBER_KEERTI.model;


public class Rider {
    private String name;
    private double rating;

    public Rider(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getRiderName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
}