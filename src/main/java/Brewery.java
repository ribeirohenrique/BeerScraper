import java.util.ArrayList;
import java.util.List;

public class Brewery {

    private String name;
    private String location;

    private List<Brew> brews = new ArrayList<>();

    public Brewery(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Brew> getBrews() {
        return brews;
    }

    public void setBrews(List<Brew> brews) {
        this.brews = brews;
    }

    @Override
    public String toString() {
        return "Brewery { " +
                "name = '" + name + '\'' +
                ", location = '" + location + '\'' +
                ", brews = " + brews +
                '}';
    }
}
