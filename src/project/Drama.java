package project;

public class Drama extends Film {
    private String relationship;
    private String statesOfHumanLife;

    public Drama(String scenario, String director, String actors, String operator, int year, String relationship, String statesOfHumanLife) {
        super(scenario, director, actors, operator, year);
        setRelationship(relationship);
        setStatesOfHumanLife(statesOfHumanLife);
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        if (relationship != null && !relationship.isEmpty()) {
            this.relationship = relationship;
        }
    }

    public String getStatesOfHumanLife() {
        return statesOfHumanLife;
    }

    public void setStatesOfHumanLife(String statesOfHumanLife) {
        if (statesOfHumanLife != null && !statesOfHumanLife.isEmpty()) {
            this.statesOfHumanLife = statesOfHumanLife;
        }

    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Relationship - " + relationship + '\n' +
                "States Of Human Life - " + statesOfHumanLife ;
    }
}
