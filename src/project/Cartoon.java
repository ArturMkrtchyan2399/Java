package project;

public class Cartoon extends Film {
    private String typeOfCartoon;
    private double duration;

    public Cartoon(String scenario, String director, String actors, String operator, int year, String typeOfCartoon, double duration) {
        super(scenario, director, actors, operator, year);
        this.typeOfCartoon = typeOfCartoon;
        this.duration = duration;
    }

    public String getTypeOfCartoon() {
        return typeOfCartoon;
    }

    public void setTypeOfCartoon(String typeOfCartoon) {
        if (typeOfCartoon != null && !typeOfCartoon.isEmpty()) {
            this.typeOfCartoon = typeOfCartoon;
        }
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration > 0) {
            this.duration = duration;
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Type Of Cartoon - " + typeOfCartoon + '\n' +
                "Duration - " + duration;
    }
}
