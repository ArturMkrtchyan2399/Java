package myproject.model;

public class Atlas extends NonFiction {
    private String region;
    private String typeOfAtlas;

    public Atlas(String name, String author, double price, String language, String region, String typeOfAtlas) {
        super(name, author, price, language);
        setRegion(region);
        setTypeOfAtlas(typeOfAtlas);

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if (region != null && !region.isEmpty()) {
            this.region = region;
        }
    }

    public String getTypeOfAtlas() {
        return typeOfAtlas;
    }

    public void setTypeOfAtlas(String typeOfAtlas) {
        if (typeOfAtlas != null && !typeOfAtlas.isEmpty()) {
            this.typeOfAtlas = typeOfAtlas;
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Region - " + region + '\n' +
                "Type Of Atlas - " + typeOfAtlas;
    }
}
