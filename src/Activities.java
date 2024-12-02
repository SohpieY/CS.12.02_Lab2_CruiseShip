import java.util.ArrayList;

//done
public abstract class Activities {
    private String name;
    private String description;
    protected double cost;
    private int capacity;
    private ArrayList<Passenger> enrolledPassengers;
    private Destination destination;

    public Activities(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Passenger> getEnrolledPassengers(){
        return enrolledPassengers;
    }

    public void setEnrolledPassengers(ArrayList<Passenger> passengers){
        this.enrolledPassengers = passengers;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    // cheking if there is space
    public boolean hasSpace() {
        return enrolledPassengers.size() < capacity; // Check for available space
    }

    // participant signing up
    public boolean signUp(Passenger passenger) {
        if (hasSpace() && !destination.isPassengerEnrolled(passenger)) {
            enrolledPassengers.add(passenger);
            return true;
        } else {
            if(!hasSpace()){
                System.out.println("No space available for this activity.");
            } else{
                System.out.println("You are already enrolled in another activity at this destination.");
            }
            return false;
        }

    }

    public int getAvailableSpace() {
        return capacity - enrolledPassengers.size();
    }

    // abstract method --> so all methods can use
    public abstract void printDetails();

}