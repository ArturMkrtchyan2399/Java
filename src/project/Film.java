package project;

import java.util.Date;

public class Film implements Video {
    private String scenario;
    private String director;
    private String actors;
    private String operator;
    private int year;

    public Film(String scenario, String director, String actors, String operator, int year) {
        setScenario(scenario);
        setDirector(director);
        setActors(actors);
        setOperator(operator);
        setYear(year);
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        if (scenario != null && !scenario.isEmpty()) {
            this.scenario = scenario;
        }

    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director != null && !director.isEmpty()) {
            this.director = director;
        }
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        if (actors != null && !actors.isEmpty()) {
            this.actors = actors;
        }
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        if (operator != null && !operator.isEmpty()) {
            this.operator = operator;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1800) {
            this.year = year;
        }
    }



    @Override
    public String toString() {
        return "Scenario - " + scenario + '\n' +
                "Director - " + director + '\n' +
                "Actors - " + actors + '\n' +
                "Operator - " + operator + '\n' +
                "Year - " + year;
    }

    @Override
    public void play() {
        System.out.println("Film is playing");
    }

    @Override
    public void stop() {
        System.out.println("Film stopped");
    }

    @Override
    public int age() {
        return  (new Date()).getYear() + 1900 - year;
    }

    @Override
    public void setVolume(int volume) {
        if(volume>=0 && volume <=100){
            System.out.println("Volume is set to " + volume);
        }
        else{
            System.out.println("Invalid value");
        }
    }
}
