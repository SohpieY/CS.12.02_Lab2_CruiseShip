public class SeniorPassenger extends Passenger {
    private final PassengerType passengerType = PassengerType.Senior;
    private double balance;
    private static final double discount = 0.10; // Encapsulation: Hiding access from other classes

    // Constructor
    public SeniorPassenger(String name, int passengerNum, double balance) {
        super(name, passengerNum); // Call the superclass constructor
        this.balance = balance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    @Override
    public boolean checkBalance(double cost) {
        return balance > cost;
    }

    @Override
    public void updateBalance(double cost) {
        this.balance -= cost;
    }

    // Override participateInActivity to apply the discount
    @Override
    public boolean participateInActivity(Activities activity) {
        double discountedCost = activity.getCost() * (1 - discount); // Apply 10% discount
        System.out.println("Senior passenger " + getName() + " is participating in activity " + activity.getName());

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