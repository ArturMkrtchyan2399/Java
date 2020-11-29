package homework.myProject.service;

import homework.myProject.model.Programmer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ProgrammerService {

    public void addProgrammer() throws IOException {
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
        Programmer pg = new Programmer(firstName, lastName, gender, age, address, experience, salary, language);
        String data =  String.join(",", pg.getFirstName(), pg.getLastName(), pg.getGender(), Integer.toString(pg.getAge()), pg.getAddress(), Integer.toString(pg.getExperience()), Double.toString(pg.getSalary()), pg.getProgrammingLanguage()) + "\n";
        Files.write(Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\programmer.txt"),data.getBytes(), StandardOpenOption.APPEND);

    }

    public Programmer[] readProgrammerFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\programmer.txt");
        String[] lines = Files.readAllLines(path).toArray(new String[0]);
        Programmer[] programmers = new Programmer[lines.length];
        for (int i = 0; i < lines.length; ++i) {
            String[] current = lines[i].split(",");
            programmers[i] = new Programmer(current[0], current[1], current[2], Integer.parseInt(current[3]), current[4],Integer.parseInt(current[5]),Double.parseDouble(current[6]),current[7]);
        }
        return programmers;
    }

    public void printFullNames(Programmer[] programmers) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        for (Programmer programmer : programmers) {
            System.out.println("Full Name - " + programmer.getFirstName() + " " + programmer.getLastName());
        }
    }

    public void printAllMalesProgrammer(Programmer[] programmers) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        for (Programmer programmer : programmers) {
            if (programmer.getGender().equals("m")) {
                System.out.println(programmer);
            }
        }
    }

    public void printAllFemalesProgrammer(Programmer[] programmers) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        for (Programmer programmer : programmers) {
            if (programmer.getGender().equals("f")) {
                System.out.println(programmer);
            }
        }
    }

    public void printSalaryGreaterThan100(Programmer[] programmers) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        for (Programmer programmer : programmers) {
            if (programmer.getSalary() > 100) {
                System.out.println(programmer);
            }
        }
    }

    public void printByProgrammingLanguage(Programmer[] programmers, String language) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        if (language == null && language.isEmpty()) {
            System.out.println("Invalid language");
        }
        for (Programmer programmer : programmers) {
            if (programmer.getProgrammingLanguage().toLowerCase().equals(language.toLowerCase())) {
                System.out.println(programmer);
            }
        }
    }


    public void printProgrammerSortedBySalary(Programmer[] programmers) {
        if(programmers.length == 0){
            System.out.println("There is no programmers");
            return;
        }
        for (int i = 0; i < programmers.length - 1; i++) {
            for (int j = i + 1; j < programmers.length; j++) {
                if (programmers[i].getSalary() > programmers[j].getSalary()) {
                    Programmer temp = programmers[i];
                    programmers[i] = programmers[j];
                    programmers[j] = temp;
                }
            }
        }
        for (Programmer programmer : programmers) {
            System.out.println(programmer);
        }
    }

}
