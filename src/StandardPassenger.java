public class StandardPassenger extends Passenger{
    private final PassengerType passengerType = PassengerType.Standard;
    private double balance;

    public StandardPassenger(String name, int passengerNum, double balance){
        super(name, passengerNum);
        this.balance = balance;

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
        System.out.println("Standard passenger " + getName() + " is participating in activity " + activity.getName());

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
        System.out.println("The name of this passenger is " + this.getName());
        System.out.println("The number of this passenger is " + this.getPassengerNum());
        System.out.println("This passenger is a " + passengerType + " passenger");
        System.out.println("The current balance of this passenger is " + balance);
        System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
        System.out.println("These activities are: ");
        this.getSignedUpActivities().forEach((activity) -> {
            System.out.println("The destination of this activity is " + activity.getDestination());
            System.out.println("The price of this activity is " + activity.getCost());
            System.out.println("---------------------------------------------");
        });
        System.out.println("---------------------------------------------");
    }

}
