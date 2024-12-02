public class SeniorPassenger extends Passenger {
    private final PassengerType passengerType = PassengerType.Senior;
    private double originalBalance;
    private double balance;
    private static final double discount = 0.10; // Encapsulation: Hiding access from other classes

    // Constructor
    public SeniorPassenger(String name, int passengerNum, double balance) {
        super(name, passengerNum); // Call the superclass constructor
        this.originalBalance = balance;
        this.balance = balance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public double getOriginalBalance() {
        return originalBalance;
    }

    public void setOriginalBalance(double originalBalance) {
        this.originalBalance = originalBalance;
    }

    @Override
    public boolean checkBalance(double cost) {
        return balance > cost;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void updateBalance(double cost) {
        this.balance -= cost;
    }

    // Override participateInActivity to apply the discount
    @Override
    public boolean participateInActivity(Activities activity) {
        double discountedCost = activity.getCost() * (1 - discount); // Apply 10% discount

        // Deduct the discounted cost from balance
        if (checkBalance(discountedCost)) {
            signedUpActivities.add(activity);
            updateBalance(discountedCost);
            activity.signUp(this); // Sign up for the activity
            return true;
        }

        return false; // Unable to participate due to insufficient balance
    }

    @Override
    public void printDetails() {
        if(this.getSignedUpActivities().size() == 0){
            System.out.println("The name of this passenger is " + this.getName());
            System.out.println("The number of this passenger is " + this.getPassengerNum());
            System.out.println("This passenger is a " + passengerType + " passenger");
            System.out.println("The current balance of this passenger is " + balance);
            System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
            System.out.println("Would you like to sign up?");
            System.out.println("---------------------------------------------");

        }else{
            System.out.println("The name of this passenger is " + this.getName());
            System.out.println("The number of this passenger is " + this.getPassengerNum());
            System.out.println("This passenger is a " + passengerType + " passenger");
            System.out.println("The original balance of this passenger is " + this.getOriginalBalance());
            System.out.println("The current balance of this passenger is " + balance);
            System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
            System.out.println("These activities are: ");
            this.getSignedUpActivities().forEach((activity) -> {
                System.out.println("Activity Name: " + activity.getName());
                double cost = activity.getCost() * (1 - discount); // Calculate discounted cost
                System.out.println("The price of this activity is " + cost + " (after discount)");
            });
            System.out.println("---------------------------------------------");

        }

    }

}