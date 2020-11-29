package homework.myProject.model;


public class Student extends Human {
    private int studentdID;
    private double mark;

    public Student(String firstName, String lastName, String gender, int age, int studentdID, double mark) {
        super(firstName, lastName, gender, age);
        setStudentdID(studentdID);
        setMark(mark);
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
            System.out.println("Invalid mark");
        }
    }

    public int getStudentdID() {
        return studentdID;
    }

    public void setStudentdID(int studentdID) {
        if (studentdID > 0) {
            this.studentdID = studentdID;
        } else {
            System.out.println("Invalid Student ID");
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n'+
                "Mark - " + mark + "\n";
    }
}
