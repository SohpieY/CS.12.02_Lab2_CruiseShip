public class StandardPassenger extends Passenger{
    private final PassengerType passengerType = PassengerType.Standard;
    private double balance;
    private double originalBalance;


    public StandardPassenger(String name, int passengerNum, double balance){
        super(name, passengerNum);
        this.originalBalance = balance;
        this.balance = balance;

    }

    public double getOriginalBalance() {
        return originalBalance;
    }

    public void setOriginalBalance(double originalBalance) {
        this.originalBalance = originalBalance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean checkBalance(double cost) {
        return balance > cost;
    }

    @Override
    public void updateBalance(double cost) {
        this.balance -= cost;
    }

    @Override
    public boolean participateInActivity(Activities activity) {
        double activityCost = activity.getCost();

        // Deduct the discounted cost from balance
        if (checkBalance(activityCost)) {
            signedUpActivities.add(activity);
            updateBalance(activityCost);
            activity.signUp(this); // Sign up for the activity
            return true;
        }

        return false; // Unable to participate due to insufficient balance
    }

    @Override
    public void printDetails() {
        if (this.getSignedUpActivities().size() == 0) {
            System.out.println("The name of this passenger is " + this.getName());
            System.out.println("The number of this passenger is " + this.getPassengerNum());
            System.out.println("This passenger is a " + passengerType + " passenger");
            System.out.println("The current balance of this passenger is " + balance);
            System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
            System.out.println("Would you like to sign up?");
            System.out.println("---------------------------------------------");

        } else {
            System.out.println("The name of this passenger is " + this.getName());
            System.out.println("The number of this passenger is " + this.getPassengerNum());
            System.out.println("This passenger is a " + passengerType + " passenger");
            System.out.println("The original balance of this passenger is " + this.getOriginalBalance());
            System.out.println("The current balance of this passenger is " + balance);
            System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
            System.out.println("These activities are: ");
            this.getSignedUpActivities().forEach((activity) -> {
                System.out.println("Activity Name: " + activity.getName());
                System.out.println("The price of this activity is " + activity.getCost());
                System.out.println("---------------------------------------------");
            });
            System.out.println("---------------------------------------------");

        }
    }

}
