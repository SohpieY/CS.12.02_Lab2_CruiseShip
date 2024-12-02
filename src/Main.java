import java.util.ArrayList;

public class Main {
    private CruiseShip cruiseShip;

    public static void main(String[] args) {
        Main main = new Main();
        main.initializeCruiseShip();
        main.runScenarios();
    }

    public void initializeCruiseShip() {
        cruiseShip = new CruiseShip("Sophie's Ship", 1800);

        Passenger passengerOne = new PremiumPassenger("Katie Fu", 1000);
        Passenger passengerTwo = new SeniorPassenger("Meagan Hsu", 1001, 200.0);
        Passenger passengerThree = new PremiumPassenger("Bridget Tang", 1002);
        Passenger passengerFour = new SeniorPassenger("Mr. Ewing", 1003, 10000.0);
        Passenger passengerFive = new SeniorPassenger("Ms. Nahar", 1004, 10000.0);
        Passenger passengerSix = new SeniorPassenger("Sophie Yan", 1005, 1000.0);

        cruiseShip.addPassenger(passengerOne);
        cruiseShip.addPassenger(passengerTwo);
        cruiseShip.addPassenger(passengerThree);
        cruiseShip.addPassenger(passengerFour);
        cruiseShip.addPassenger(passengerFive);
        cruiseShip.addPassenger(passengerSix);

        Destination destinationOne = new Destination("Paris", activitiesOne);
        Destination destinationTwo = new Destination("New York", activitiesTwo);
        Destination destinationThree = new Destination("Barcelona", activitiesThree);

        visitAttraction activityOne = new visitAttraction("Eiffel Tower Visit",
                "Enjoy panoramic views from the Eiffel Tower",
                75.0, 8,
                destinationOne,
                "Eiffel Tower");

        watchTheatre activityTwo = new watchTheatre("Broadway Night",
                "Musical theatre show",
                100.0, 15,
                destinationTwo,
                "Broadway Night",
                new ArrayList<>());
        activityTwo.addActor(new theatreActor("John Smith", "The Phantom"));
        activityTwo.addActor(new theatreActor("Emily Davis", "Christine Daaé"));

        walkingTour activityThree = new walkingTour("City Walking Tour",
                "Historical landmarks tour",
                20.0, 5, destinationThree,
                "Gothic Quarter, La Rambla, Park Güell",
                10.0);

        destinationOne.addActivity(activityOne);
        destinationTwo.addActivity(activityTwo);
        destinationThree.addActivity(activityThree);

        Cabin cabinOne = new Cabin("1A", passengerOne, true);
        Cabin cabinTwo = new Cabin("1B", false);
        Cabin cabinThree = new Cabin("2A", false);

        cruiseShip.addCabin(cabinOne);
        cruiseShip.addCabin(cabinTwo);
        cruiseShip.addCabin(cabinThree);
    }

    public void runScenarios() {
        System.out.println("=== Scenario 1: Print Cruise Itinerary ===");
        printItinerary();

        System.out.println("\n=== Scenario 2: Print Passenger List ===");
        printPassengerList();

        System.out.println("\n=== Scenario 3: Print Individual Passenger Details ===");
        printPassengerDetails(cruiseShip.getPassengers().get(0));

        System.out.println("\n=== Scenario 4: Print Available Activities ===");
        printAvailableActivities();

        System.out.println("\n=== Scenario 5: Print Cabin Allocations and Activities ===");
        printCabinAllocation();
    }

    private void printItinerary() {
        cruiseShip.printItinerary();
    }

    private void printPassengerList() {
        cruiseShip.printCruise();
    }

    private void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNum());
        if (passenger instanceof SeniorPassenger) {
            System.out.println("Balance: $" + ((SeniorPassenger) passenger).getBalance());
        }
        System.out.println("Activities Signed Up For:");
        for (Activities activity : passenger.getActivitiesSignedUpFor()) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getDestination() +
                    " - Price: $" + activity.getCost());
        }
    }

    private void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : cruiseShip.getItinerary()) {
            for (Activities activity : destination.getActivitiesList()) {
                if (activity.getAvailableSpace() > 0) {
                    System.out.println("- " + activity.getName() + " - Available Spaces: " +
                            activity.getAvailableSpace());
                }
            }
        }
    }


    private void printCabinAllocation() {
        System.out.println("Cabin Allocation and Activities:");
        for (Cabin cabin : cruiseShip.getCabinList()) {
            cabin.printDetails();


            for (Destination destination : cruiseShip.getItinerary()) {
                System.out.println("Available activities at " + destination.getDestination() + ":");
                destination.printAvailableActivity();
            }
            System.out.println();
        }
    }
}



