package homework.myProject.model;

public abstract class Human {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public Human(String firstName, String lastName, String gender, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && firstName.matches("[A-Za-z]+")) {
            this.firstName = firstName;
        } else {
            System.out.println("Invalid first name");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.matches("[A-Za-z]+")) {
            this.lastName = lastName;
        } else {
            System.out.println("Invalid lastName name");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && !gender.isEmpty()) {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    @Override
    public String toString() {
        return "First Name - " + getFirstName() + '\n' +
                "Last Name - " + getLastName() + '\n' +
                "Gender - " + getGender() + '\n' +
                "Age - " + getAge();
    }
}

