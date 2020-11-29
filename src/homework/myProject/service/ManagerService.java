package homework.myProject.service;


import homework.myProject.model.Manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ManagerService {

    public void addManager() throws IOException {
        System.out.println("Fill in details");
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter First Name");
        String firstName = s.nextLine();
        System.out.println("Please Enter Last Name");
        String lastName = s.nextLine();
        System.out.println("Please Enter Gender (m/f)" );
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
        Manager mn = new Manager(firstName,lastName,gender,age,address,experience,salary,teamSize);
        String data = String.join(",",mn.getFirstName(),mn.getLastName(),mn.getGender(),Integer.toString(mn.getAge()),mn.getAddress(),Integer.toString(mn.getExperience()),Double.toString(mn.getSalary()),Integer.toString(mn.getTeamSize()))+"\n";
        Files.write(Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\manager.txt"),data.getBytes(), StandardOpenOption.APPEND);

    }
    public Manager[] readManagerFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\manager.txt");
        String[] lines = Files.readAllLines(path).toArray(new String[0]);
        Manager[] managers = new Manager[lines.length];
        for (int i = 0; i < lines.length; ++i) {
            String[] current = lines[i].split(",");
            managers[i] = new Manager(current[0], current[1], current[2], Integer.parseInt(current[3]), current[4],Integer.parseInt(current[5]),Double.parseDouble(current[6]),Integer.parseInt(current[7]));
        }
        return managers;
    }

    public void printFullNames(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            System.out.println("Full Name - " + manager.getFirstName() + " " + manager.getLastName());
        }
    }

    public void printAllMalesManagers(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getGender().equals("m")) {
                System.out.println(manager);
            }
        }
    }

    public void printAllFemalesManagers(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getGender().equals("f")) {
                System.out.println(manager);
            }
        }
    }

    public void printTeamSizeGreaterThan3(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getTeamSize() > 3) {
                System.out.println(manager);
            }
        }
    }

    public void printSalaryGreaterThan150(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (Manager manager : managers) {
            if (manager.getSalary() > 150) {
                System.out.println(manager);
            }
        }
    }


    public void printManagerSortedByTeamSize(Manager[] managers) {
        if(managers.length == 0){
            System.out.println("There is no managers");
            return;
        }
        for (int i = 0; i < managers.length - 1; i++) {
            for (int j = i + 1; j < managers.length; j++) {
                if (managers[i].getTeamSize() > managers[j].getTeamSize()) {
                    Manager temp = managers[i];
                    managers[i] = managers[j];
                    managers[j] = temp;
                }
            }
        }
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }

}
