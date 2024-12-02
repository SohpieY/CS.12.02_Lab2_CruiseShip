import java.util.List;
//done
public class watchTheatre extends Activities{
    private String showName;
    private List<theatreActor> actorList;

    public watchTheatre(String name, String description, double cost, int capacity, Destination destination, String showName, List<theatreActor> actorList) {
        super(name, description, cost, capacity, destination);
        this.showName = showName;
        this.actorList = actorList;
    }


    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public List<theatreActor> getActorList() {
        return actorList;
    }

    public void setActorList(List<theatreActor> actorList) {
        this.actorList = actorList;
    }

    public void addActor(theatreActor actor){
        actorList.add(actor);
    }

    public void printDetails(){
        System.out.println("\n Theatre Show: " + getName());
        System.out.println("\n Description: " + getDescription());
        System.out.println("\n Cost: $" + getCost());
        System.out.println("\n Capacity: " + getCapacity());
        System.out.println("\n Starring:");

        for(theatreActor actor: actorList){
            System.out.println("-" + actor.toString());
        }

        System.out.println("---------------------------------------------");
    }
}
