package homework.myProject.model;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String firstName, String lastName, String gender, int age, String address, int experience, double salary, int teamSize) {
        super(firstName, lastName, gender, age, address, experience, salary);
        setTeamSize(teamSize);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if (teamSize > 0) {
            this.teamSize = teamSize;
        } else {
            System.out.println("Invalid team size");
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Team Size - " + teamSize + "\n";
    }
}
