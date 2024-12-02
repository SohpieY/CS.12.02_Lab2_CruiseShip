import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    private String name;
    private int passengerNum;
    protected List<Activities> signedUpActivities;

    //constructors
    public Passenger(String name, int passengerNum){
        this.name = name;
        this.passengerNum = passengerNum;
        this.signedUpActivities = new ArrayList<>();
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    public List<Activities> getSignedUpActivities() {
        return signedUpActivities;
    }

    public void setSignedUpActivities(List<Activities> signedUpActivities) {
        this.signedUpActivities = signedUpActivities;
    }

    // Method to check current balance
    public abstract boolean checkBalance(double cost);

    // Method to deduct balance for activity cost
    public abstract void updateBalance(double cost);

    // Method for participating in an activity
    public abstract boolean participateInActivity(Activities activity);

    // Method to print passenger details
    public abstract void printDetails();
}