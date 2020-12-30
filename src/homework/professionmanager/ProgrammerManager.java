package homework.professionmanager;

import homework.myProject.service.ProgrammerService;

import java.util.Scanner;

public class ProgrammerManager implements ProfessionManager {
    @Override
    public void manage() {
        ProgrammerService programmer = ProgrammerService.getInstance();
        boolean isProgrammerActive = true;
        Scanner s = new Scanner(System.in);
        while (isProgrammerActive) {
            System.out.println("1. Add Programmer");
            System.out.println("2. Print Full Names");
            System.out.println("3. Print All Females");
            System.out.println("4. Print All Males");
            System.out.println("5. Print all programmers whose salary greater than 100");
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
                    programmer.printAllFemales(programmer.readProgrammerFile());
                    break;
                case 4:
                    programmer.printAllMales(programmer.readProgrammerFile());
                    break;
                case 5:
                    programmer.printSalaryGreaterThan100(programmer.readProgrammerFile());
                    break;
                case 6:
                    System.out.println("Enter programming language");
                    s.nextLine();
                    String language = s.nextLine();
                    programmer.printByProgrammingLanguage(programmer.readProgrammerFile(), language);
                    break;
                case 7:
                    programmer.printProgrammerSortedBySalary(programmer.readProgrammerFile());
                    break;
                case 8:
                    System.out.println("EXIT");
                    isProgrammerActive = false;
                    break;
                default:
                    System.out.println("Invalid case");
            }
        }
    }
}
