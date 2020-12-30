package homework.myProject.professionmanager;

import homework.myProject.service.ManagerService;

import java.util.Scanner;

public class ManagerManager implements ProfessionManager {
    @Override
    public void manage() {
        ManagerService manager = ManagerService.getInstance();

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
                    manager.printAllFemales(manager.readManagerFile());
                    break;
                case 4:
                    manager.printAllMales(manager.readManagerFile());
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
                default:
                    System.out.println("Invalid case");
            }
        }
    }
}
