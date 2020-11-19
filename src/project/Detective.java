package project;

public class Detective extends Film {
    private String disclosureOfEvents;
    private String disclosureOfPerpetrators;
    private boolean isSuspiciousCases;

    public Detective(String scenario, String director, String actors, String operator, int year, String disclosureOfEvents, String disclosureOfPerpetrators, boolean isSuspiciousCases) {
        super(scenario, director, actors, operator, year);
        setDisclosureOfEvents(disclosureOfEvents);
        setDisclosureOfPerpetrators(disclosureOfPerpetrators);
        setSuspiciousCases(isSuspiciousCases);
    }

    public String getDisclosureOfEvents() {
        return disclosureOfEvents;
    }

    public void setDisclosureOfEvents(String disclosureOfEvents) {
        if (disclosureOfEvents != null && !disclosureOfEvents.isEmpty()) {
            this.disclosureOfEvents = disclosureOfEvents;
        }
    }

    public String getDisclosureOfPerpetrators() {
        return disclosureOfPerpetrators;
    }

    public void setDisclosureOfPerpetrators(String disclosureOfPerpetrators) {
        if (disclosureOfPerpetrators != null && !disclosureOfPerpetrators.isEmpty()) {
            this.disclosureOfPerpetrators = disclosureOfPerpetrators;
        }
    }

    public boolean isSuspiciousCases() {
        return isSuspiciousCases;
    }

    public void setSuspiciousCases(boolean suspiciousCases) {
        isSuspiciousCases = suspiciousCases;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Disclosure Of Events - " + disclosureOfEvents + '\n' +
                "Disclosure Of Perpetrators - " + disclosureOfPerpetrators + '\n' +
                "Is Suspicious Cases - " + isSuspiciousCases ;
    }
}
