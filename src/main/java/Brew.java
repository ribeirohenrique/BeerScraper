public class Brew {
    private String name;
    private String abv;
    private int ibu;

    public Brew(String name, String abv, int ibu) {
        this.name = name;
        this.abv = abv;
        this.ibu = ibu;
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

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    @Override
    public String toString() {
        return "Brew { " +
                "name = '" + name + '\'' +
                ", abv = '" + abv + '\'' +
                ", ibu = " + ibu +
                '}';
    }
}
