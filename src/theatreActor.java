//done
public class theatreActor{
    private String name;
    private String character;

    public theatreActor(String name, String character){
        this.name = name;
        this.character = character;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCharacter(){
        return character;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public String toString(){
        return name + " as " + character;
    }
}
