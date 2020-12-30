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
            throw new IllegalArgumentException("Invalid team size");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append(super.toString())
                .append("\nTeam Size - ")
                .append(teamSize)
                .append("\n");
        return sb.toString();
    }
}
