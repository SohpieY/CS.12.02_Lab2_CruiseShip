public class Cabin {
    private String cabinName;
    private Passenger passenger;
    private boolean isOccupied;
    private boolean isPremium;

    // Constructor for creating a cabin with an occupant
    public Cabin(String cabinName, Passenger occupant, boolean isPremium) {
        this.cabinName = cabinName;
        this.passenger = occupant;
        this.isPremium = isPremium;
        this.isOccupied = occupant != null; // Set occupation based on occupant
    }

    // Constructor for creating an empty cabin
    public Cabin(String cabinName, boolean isPremium) {
        this.cabinName = cabinName;
        this.passenger = null;
        this.isPremium = isPremium;
        this.isOccupied = false; // Initially unoccupied
    }

    // Getters & Setters
    public String getCabinName() {
        return cabinName;
    }

    public void setCabinName(String cabinName) {
        this.cabinName = cabinName;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
        this.isOccupied = (passenger != null); //
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    // Methods
    public boolean addPassenger(Passenger passenger) {
        if (isOccupied) {
            System.out.println("Cabin is already occupied, please book another cabin!");
            return false;
        }
        if (isPremium && !(passenger instanceof PremiumPassenger)) {
            System.out.println("Only premium passengers can have access to this cabin! Please choose a standard cabin.");
            return false;
        }

        this.passenger = passenger;
        this.isOccupied = true; // Mark the cabin as occupied
        return true;
    }

    public void removePassenger() {
        this.passenger = null;
        this.isOccupied = false; // Mark the cabin as unoccupied
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void printDetails() {
        System.out.println("Cabin " + cabinName + ":");
        if (isOccupied) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNum());
        } else {
            System.out.println("Unoccupied");
        }
        System.out.println("---------------------------------------------");
    }
}