public class walkingTour extends Activities{
    private String trail;
    private double distance;

    public walkingTour(String name, String description, double cost, int capacity, Destination destination, String trail, double distance) {
        super(name, description, cost, capacity, destination);
        this.trail = trail;
        this.distance = distance;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void printDetails() {
        System.out.println("Trail Name: " + getTrail());
        System.out.println("Description: " + getDescription());
        System.out.println("Distance: " + getDistance());
        System.out.println("Cost: " + getCost());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("---------------------------------------------");
    }
}
