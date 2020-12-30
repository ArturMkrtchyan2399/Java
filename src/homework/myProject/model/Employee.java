package homework.myProject.model;

public abstract class Employee extends Human {
    private String address;
    private int experience;
    private double salary;

    public Employee(String firstName, String lastName, String gender, int age, String address, int experience, double salary) {
        super(firstName, lastName, gender, age);
        setAddress(address);
        setExperience(experience);
        setSalary(salary);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address ");
        }
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        } else {
            throw new IllegalArgumentException("Invalid experience");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Invalid salary");
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Address - " + address + '\n' +
                "Experience - " + experience + '\n' +
                "Salary - " + salary;
    }
}
