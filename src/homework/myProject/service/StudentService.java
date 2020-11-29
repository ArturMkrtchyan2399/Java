package homework.myProject.service;


import homework.myProject.model.Student;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class StudentService {


    public void addStudent() throws IOException {
        System.out.println("Fill in details");
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter First Name");
        String firstName = s.nextLine();
        System.out.println("Please Enter Last Name");
        String lastName = s.nextLine();
        System.out.println("Please Enter Gender (m/f)");
        String gender = s.nextLine();
        System.out.println("Please enter Age");
        int age = s.nextInt();
        System.out.println("Please Enter Student ID");
        int studentID = s.nextInt();
        System.out.println("Please Enter Mark");
        double mark = s.nextDouble();
        Student st = new Student(firstName, lastName, gender, age, studentID, mark);
        String data = String.join(",", st.getFirstName(), st.getLastName(), st.getGender(), Integer.toString(st.getAge()), Integer.toString(st.getStudentdID()), Double.toString(st.getMark())) + "\n";
        Files.write(Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\student.txt"), data.getBytes(), StandardOpenOption.APPEND);
    }

    public Student[] readStudentFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\student.txt");
        String[] lines = Files.readAllLines(path).toArray(new String[0]);
        Student[] students = new Student[lines.length];
        for (int i = 0; i < lines.length; ++i) {
            String[] current = lines[i].split(",");
            students[i] = new Student(current[0], current[1], current[2], Integer.parseInt(current[3]), Integer.parseInt(current[4]), Double.parseDouble(current[5]));
        }
        return students;
    }

    public void printFullNames(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            System.out.println("Full Name - " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void printAllMales(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("m")) {
                System.out.println(student);
            }
        }
    }

    public void printAllFemales(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("f")) {
                System.out.println(student);
            }
        }
    }


    public void printAllFemalesGreaterThan50(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("f") && student.getMark() > 50) {
                System.out.println(student);
            }
        }
    }

    public void printAllMalesGreaterThan50(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("m") && student.getMark() > 50) {
                System.out.println(student);
            }
        }
    }

    public void printStudentSortedByMark(Student[] students) {
        if (students.length == 0) {
            System.out.println("There is no students");
            return;
        }
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getMark() > students[j].getMark()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
