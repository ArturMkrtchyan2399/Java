package project;

public class Adventure extends Film {
    private boolean isHappyEnd;
    private String ingenuityOfPersonages;

    public Adventure(String scenario, String director, String actors, String operator, int year, boolean isHappyEnd, String ingenuityOfPersonages) {
        super(scenario, director, actors, operator, year);
        setHappyEnd(isHappyEnd);
        setIngenuityOfPersonages(ingenuityOfPersonages);

    }

    public boolean isHappyEnd() {
        return isHappyEnd;
    }

    public void setHappyEnd(boolean happyEnd) {
        isHappyEnd = happyEnd;
    }

    public String getIngenuityOfPersonages() {
        return ingenuityOfPersonages;
    }

    public void setIngenuityOfPersonages(String ingenuityOfPersonages) {
        if (ingenuityOfPersonages != null && !ingenuityOfPersonages.isEmpty()) {
            this.ingenuityOfPersonages = ingenuityOfPersonages;
        }

    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Ingenuity Of Personages - " + ingenuityOfPersonages;
    }
}
