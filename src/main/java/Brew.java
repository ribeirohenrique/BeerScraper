import java.util.ArrayList;
import java.util.List;

public class Brew {
    private String name;

    private String type;
    private String abv;
    private String ibu;

    private String brewery;

    //TODO: Adicionar o IBU no construtor posteriormente


    public Brew(String name, String type, String abv, String brewery) {
        this.name = name;
        this.type = type;
        this.abv = abv;
        this.brewery = brewery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }


    @Override
    public String toString() {
        return "Beer: \n" +
                "Name: " + name + "\nType: " + type + "\nABV: " + abv + "\nBrewery: " + brewery + "\n";
    }
}
