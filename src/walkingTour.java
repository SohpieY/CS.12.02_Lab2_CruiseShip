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
        System.out.println("\n Trail Name: " + getTrail());
        System.out.println("\n Description: " + getDescription());
        System.out.println("\n Distance: " + getDistance());
        System.out.println("\n Cost: " + getCost());
        System.out.println("\n Capacity: " + getCapacity());
        System.out.println("---------------------------------------------");
    }
}
