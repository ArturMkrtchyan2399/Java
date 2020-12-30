package homework.myProject.menumanager;

import homework.professionmanager.ManagerManager;
import homework.professionmanager.ProgrammerManager;
import homework.professionmanager.StudentManager;

import java.util.Scanner;

public class ProfessionMenuManager {

    public void manageProfession() {
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
                    new StudentManager().manage();
                    break;
                case 2:
                    new ProgrammerManager().manage();
                    break;
                case 3:
                    new ManagerManager().manage();
                    break;
                case 4:
                    System.out.println("EXIT");
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("Invalid case");
            }
        }
    }
}
