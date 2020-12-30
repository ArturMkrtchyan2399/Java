package homework.myProject.service;


import homework.myProject.config.DBPaths;
import homework.myProject.model.Manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerService extends HumanService implements DBPaths {
    private static final ManagerService instance = new ManagerService();

    private ManagerService() {
    }

    public static ManagerService getInstance() {
        return instance;
    }

    public void addManager() {
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
        System.out.println("Please enter team size");
        int teamSize = s.nextInt();
        Manager mn;
        try {
            mn = new Manager(firstName, lastName, gender, age, address, experience, salary, teamSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String data = String.join(",", mn.getFirstName(), mn.getLastName(), mn.getGender(), Integer.toString(mn.getAge()), mn.getAddress(), Integer.toString(mn.getExperience()), Double.toString(mn.getSalary()), Integer.toString(mn.getTeamSize())) + "\n";
        try {
            Files.write(managersPath, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Manager> readManagerFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(managersPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Manager> managers = new ArrayList<>();
        for (String line : lines) {
            String[] current = line.split(",");
            managers.add(new Manager(current[0],
                    current[1],
                    current[2],
                    Integer.parseInt(current[3]),
                    current[4],
                    Integer.parseInt(current[5]),
                    Double.parseDouble(current[6]),
                    Integer.parseInt(current[7])));
        }
        return managers;
    }

    public void printTeamSizeGreaterThan3(List<Manager> managers) {
        if (managers.isEmpty()) {
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getTeamSize() > 3) {
                System.out.println(manager);
            }
        }
    }

    public void printSalaryGreaterThan150(List<Manager> managers) {
        if (managers.isEmpty()) {
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getSalary() > 150) {
                System.out.println(manager);
            }
        }
    }


    public void printManagerSortedByTeamSize(List<Manager> managers) {
        if (managers.isEmpty()) {
            System.out.println("There is no managers");
            return;
        }
        managers.sort((o1, o2) -> o1.getTeamSize() - o2.getTeamSize());
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }

}
