
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CruiseShip {
    private String name;
    private int capacity;
    private ArrayList<Passenger> passengers;
    private ArrayList<Destination> itinerary;
    private ArrayList<Cabin> cabinList;

    //constructor
    public CruiseShip(String name, int capacity){
        passengers = new ArrayList<>();
        itinerary = new ArrayList<>();
        cabinList = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(ArrayList<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public ArrayList<Cabin> getCabinList() {
        return cabinList;
    }


    public void setCabinList(ArrayList<Cabin> cabinList) {
        this.cabinList = cabinList;
    }

    //methods here!

    public boolean addPassenger(Passenger passenger){
        // Add a validation check here.
        // Need to know if the cruise ship is already full or not
        // If the cruise ship is already full of passengers
        if (passengers.size() == capacity) {
            System.out.println("This cruise ship is already full, cannot add more passengers!");
            return false;
        }

        // Otherwise add the passenger.
        passengers.add(passenger);
        return true;
    }

    public void addDestination(Destination destination){
        itinerary.add(destination);
    }

    public void addCabin(Cabin cabin){
        cabinList.add(cabin);
    }


    public void printItinerary(){
        //print itinerary here
        System.out.println("The itinerary of this cruise ship is: ");
        itinerary.forEach((destination) -> {
            System.out.println("\n The name of this destination is: " + destination.getDestination());
            ArrayList<Activities> activities = destination.getActivitiesList();
            System.out.println("\n There are " + activities.size() + " activities at " + destination.getDestination());
            activities.forEach(Activities::printDetails);
        });
    }


    public void printCruise(){
        //including the ship name + capacity
        System.out.println("\nCruise Ship Name: " + name);
        System.out.println("\nCapacity: " + capacity);
        // print number of cabins
        System.out.println("\nNumber of cabins in the cruise ship: ");
        System.out.println(cabinList.size());
        //Print the passenger list, number of passengers currently on the cruise, and the name and number of each passenger on the cruise.
        System.out.println("\nThe passenger list is shown below: ");
        System.out.println("---------------------------------------------");
        passengers.forEach(Passenger::printDetails);
    }

    public void printCabinAllocation() {
        System.out.println("Cabin allocation for " + name + ":");
        for (Cabin cabin : cabinList) {
            cabin.printDetails(); // Use the printDetails method in Cabin
        }
    }
}

