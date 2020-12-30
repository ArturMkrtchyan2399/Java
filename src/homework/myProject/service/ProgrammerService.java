package homework.myProject.service;

import homework.myProject.config.DBPaths;
import homework.myProject.model.Programmer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammerService extends HumanService implements DBPaths {
    private static final ProgrammerService instance = new ProgrammerService();

    private ProgrammerService() {
    }

    public static ProgrammerService getInstance() {
        return instance;
    }

    public void addProgrammer() {
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
        System.out.println("Please Enter Address");
        s.nextLine();
        String address = s.nextLine();
        System.out.println("Please enter Experience");
        int experience = s.nextInt();
        System.out.println("Please enter salary");
        double salary = s.nextDouble();
        System.out.println("Please Enter Programming language");
        s.nextLine();
        String language = s.nextLine();
        Programmer pg;
        try {
            pg = new Programmer(firstName, lastName, gender, age, address, experience, salary, language);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        String data = String.join(",", pg.getFirstName(), pg.getLastName(), pg.getGender(), Integer.toString(pg.getAge()), pg.getAddress(), Integer.toString(pg.getExperience()), Double.toString(pg.getSalary()), pg.getProgrammingLanguage()) + "\n";
        try {
            Files.write(programmersPath, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Programmer> readProgrammerFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(programmersPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Programmer> programmers = new ArrayList<>();
        for (String line : lines) {
            String[] current = line.split(",");
            programmers.add(new Programmer(current[0],
                    current[1],
                    current[2],
                    Integer.parseInt(current[3]),
                    current[4],
                    Integer.parseInt(current[5]),
                    Double.parseDouble(current[6]),
                    current[7]));
        }
        return programmers;
    }


    public void printSalaryGreaterThan100(List<Programmer> programmers) {
        if (programmers.isEmpty()) {
            System.out.println("There is no programmers");
            return;
        }
        for (Programmer programmer : programmers) {
            if (programmer.getSalary() > 100) {
                System.out.println(programmer);
            }
        }
    }

    public void printByProgrammingLanguage(List<Programmer> programmers, String language) {
        if (programmers.isEmpty()) {
            System.out.println("There is no programmers");
            return;
        }
        if (language == null || language.isEmpty()) {
            System.out.println("Invalid language");
            return;
        }
        for (Programmer programmer : programmers) {
            if (programmer.getProgrammingLanguage().toLowerCase().equals(language.toLowerCase())) {
                System.out.println(programmer);
            }
        }
    }


    public void printProgrammerSortedBySalary(List<Programmer> programmers) {
        if (programmers.isEmpty()) {
            System.out.println("There is no programmers");
            return;
        }

        programmers.sort((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        for (Programmer programmer : programmers) {
            System.out.println(programmer);
        }
    }

}
