package homework.myProject.main;

import homework.myProject.model.Manager;
import homework.myProject.service.ManagerService;
import homework.myProject.service.ProgrammerService;
import homework.myProject.service.StudentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("______MENU______");
            System.out.println("1. Student");
            System.out.println("2. Programmer");
            System.out.println("3. Manager");
            System.out.println("4. Exit");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    programmerMenu();
                    break;
                case 3:
                    managerMenu();
                    break;

                case 4:
                    System.out.println("EXIT");
                    isMenuActive = false;
                    break;

            }
        }
    }

    public static void studentMenu() throws IOException {
        StudentService student = new StudentService();
        boolean isStudentActive = true;
        Scanner s = new Scanner(System.in);
        while (isStudentActive) {
            System.out.println("1. Add Student");
            System.out.println("2. Print Full Names");
            System.out.println("3. Print All Females");
            System.out.println("4. Print All Males");
            System.out.println("5. Print all female students who has mark greater then 50");
            System.out.println("6. Print all male students who has mark greater then 50");
            System.out.println("7. Print Student Sorted By Mark");
            System.out.println("8. Exit");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    student.addStudent();
                    break;
                case 2:
                    student.printFullNames(student.readStudentFile());
                    break;
                case 3:
                    student.printAllFemales(student.readStudentFile());
                    break;
                case 4:
                    student.printAllMales(student.readStudentFile());
                    break;
                case 5:
                    student.printAllFemalesGreaterThan50(student.readStudentFile());
                    break;
                case 6:
                    student.printAllMalesGreaterThan50(student.readStudentFile());
                    break;
                case 7:
                    student.printStudentSortedByMark(student.readStudentFile());
                    break;
                case 8:
                    System.out.println("EXIT");
                    isStudentActive = false;
                    break;
            }
        }
    }

    public static void managerMenu() throws IOException {
        ManagerService manager = new ManagerService();
        boolean isManagerActive = true;
        Scanner s = new Scanner(System.in);
        while (isManagerActive) {
            System.out.println("1. Add Manager");
            System.out.println("2. Print Full Names");
            System.out.println("3. Print All Females");
            System.out.println("4. Print All Males");
            System.out.println("5. Print all managers whose team size greater than 3");
            System.out.println("6. Print all managers whose  salary greater than  150");
            System.out.println("7. Print Managers Sorted By team Size");
            System.out.println("8. Exit");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    manager.addManager();
                    break;
                case 2:
                    manager.printFullNames(manager.readManagerFile());
                    break;
                case 3:
                    manager.printAllFemalesManagers(manager.readManagerFile());
                    break;
                case 4:
                    manager.printAllMalesManagers(manager.readManagerFile());
                    break;
                case 5:
                    manager.printTeamSizeGreaterThan3(manager.readManagerFile());
                    break;
                case 6:
                    manager.printSalaryGreaterThan150(manager.readManagerFile());
                    break;
                case 7:
                    manager.printManagerSortedByTeamSize(manager.readManagerFile());
                    break;
                case 8:
                    System.out.println("EXIT");
                    isManagerActive = false;
                    break;
            }
        }
    }

    public static void programmerMenu() throws IOException {
        ProgrammerService programmer = new ProgrammerService();
        boolean isProgrammerActive = true;
        Scanner s = new Scanner(System.in);
        while (isProgrammerActive) {

            System.out.println("1. Add Programmer");
            System.out.println("2. Print Full Names");
            System.out.println("3. Print All Females");
            System.out.println("4. Print All Males");
            System.out.println("5. Print all programmers whose salary greater tham 100");
            System.out.println("6. Print  programmers by programming language");
            System.out.println("7. Print Programmers Sorted By salary");
            System.out.println("8. Exit");

            int n = s.nextInt();
            switch (n) {
                case 1:
                    programmer.addProgrammer();
                    break;
                case 2:
                    programmer.printFullNames(programmer.readProgrammerFile());
                    break;
                case 3:
                    programmer.printAllFemalesProgrammer(programmer.readProgrammerFile());
                    break;
                case 4:
                    programmer.printAllMalesProgrammer(programmer.readProgrammerFile());
                    break;
                case 5:
                    programmer.printSalaryGreaterThan100(programmer.readProgrammerFile());
                    break;
                case 6:
                    System.out.println("Enter programming language");
                    s.nextLine();
                    String language = s.nextLine();
                    programmer.printByProgrammingLanguage(programmer.readProgrammerFile(),language);
                    break;
                case 7:
                    programmer.printProgrammerSortedBySalary(programmer.readProgrammerFile());
                    break;
                case 8:
                    System.out.println("EXIT");
                    isProgrammerActive  = false;
                    break;
            }
        }
    }

}
