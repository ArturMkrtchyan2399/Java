package homework.myProject.service;


import homework.myProject.config.DBPaths;
import homework.myProject.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService extends HumanService implements DBPaths {
    private static final StudentService instance = new StudentService();

    private StudentService() {
    }

    public static StudentService getInstance() {
        return instance;
    }

    public void addStudent() {
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
        Student st;
        try {
            st = new Student(firstName, lastName, gender, age, studentID, mark);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String data = String.join(",", st.getFirstName(), st.getLastName(), st.getGender(), Integer.toString(st.getAge()), Integer.toString(st.getStudentdID()), Double.toString(st.getMark())) + "\n";
        try {
            Files.write(studentsPath, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readStudentFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(studentsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Student> students = new ArrayList<>();
        for (String line : lines) {
            String[] current = line.split(",");
            students.add(new Student(current[0],
                    current[1],
                    current[2],
                    Integer.parseInt(current[3]),
                    Integer.parseInt(current[4]),
                    Double.parseDouble(current[5])));
        }
        return students;
    }


    public void printAllFemalesGreaterThan50(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("f") && student.getMark() > 50) {
                System.out.println(student);
            }
        }
    }

    public void printAllMalesGreaterThan50(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There is no students");
            return;
        }
        for (Student student : students) {
            if (student.getGender().equals("m") && student.getMark() > 50) {
                System.out.println(student);
            }
        }
    }

    public void printStudentSortedByMark(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There is no students");
            return;
        }
        students.sort((o1, o2) -> (int) (o1.getMark() - o2.getMark()));
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
