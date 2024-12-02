public class visitAttraction extends Activities{
    private String attractionName;

    public visitAttraction(String name, String description, double cost, int capacity, Destination destination, String attractionName) {
        super(name, description, cost, capacity, destination);
        this.attractionName = attractionName;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    @Override
    public void printDetails() {
        System.out.println("\n Attraction Name: " + getAttractionName());
        System.out.println("\n Description: " + getDescription());
        System.out.println("\n Cost: " + getCost());
        System.out.println("\n Capacity: " + getCapacity());
        System.out.println("---------------------------------------------");
    }
}
