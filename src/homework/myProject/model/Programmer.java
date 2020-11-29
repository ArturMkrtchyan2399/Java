package homework.myProject.model;

public class Programmer extends Employee{
    private String programmingLanguage;

    public Programmer(String firstName, String lastName, String gender, int age, String address, int experience, double salary, String programmingLanguage) {
        super(firstName, lastName, gender, age, address, experience, salary);
        setProgrammingLanguage(programmingLanguage);
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage != null && !programmingLanguage.isEmpty()) {
            this.programmingLanguage = programmingLanguage;
        } else {
            System.out.println("Invalid programming language");
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Programming Language - " + programmingLanguage + "\n";
    }
}
