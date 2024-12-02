public class PremiumPassenger extends Passenger{
    private final PassengerType passengerType = PassengerType.Premium;
    public PremiumPassenger(String name, int passengerNum){
        super(name, passengerNum);
    }


    @Override
    public boolean checkBalance(double cost) {
        return false;
    }

    @Override
    public void updateBalance(double cost) {
        //empty because premium doesn't have to use balance to do activities
    }


    public PassengerType getPassengerType() {
        return passengerType;
    }

    @Override
    public boolean participateInActivity(Activities activity) {
        return activity.signUp(this); // Directly sign up for the activity
    }


    @Override
    public void printDetails() {
        if (this.getSignedUpActivities().size() == 0) {
                System.out.println("The name of this passenger is " + this.getName());
                System.out.println("The number of this passenger is " + this.getPassengerNum());
                System.out.println("This passenger is a " + passengerType + " passenger");
                System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
                System.out.println("This passenger has already enrolled in " + this.getSignedUpActivities().size() + " activities");
                System.out.println("Would you like to sign up?");
                System.out.println("---------------------------------------------");

        } else {
                System.out.println("The name of this passenger is " + this.getName());
                System.out.println("The number of this passenger is " + this.getPassengerNum());
                System.out.println("This passenger is a " + passengerType + " passenger");
                System.out.println("Since this passenger is a Premium Passenger, there's no balance apply");
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