package homework.myProject.menumanager;

import homework.myProject.model.User;
import homework.myProject.service.UserService;

import java.util.Scanner;

public class SigningMenuManager {

    UserService userService = UserService.getInstance();

    public void manageSigning() {
        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("1.| LOGIN | ");
            System.out.println("2.| REGISTER |");
            System.out.println("3.| EXIT |");
            int num = s.nextInt();
            s.nextLine();
            switch (num) {
                case 1:
                    manageLogin();
                    break;
                case 2:
                    manageRegister();
                    break;
                case 3:
                    isActive = false;
                    manageExit();
                    break;
                default:
                    System.out.println("Invalid Case");
                    break;
            }
        }
    }

    public void manageRegister() {
        System.out.println("Fill in details");
        Scanner s = new Scanner(System.in);
        System.out.println("Please Full Name ");
        String fullName = s.nextLine();
        System.out.println("Please Enter username (Username must  contain minimum 10 letter )");
        String username = s.nextLine();
        System.out.println("Please Enter Email");
        String email = s.nextLine();
        System.out.println("Please Enter password");
        String password = s.nextLine();
        userService.addUser(fullName, username, email, password);

    }

    public void manageLogin() {
        Scanner s = new Scanner(System.in);
        System.out.println("Input username ");
        String username = s.nextLine();
        System.out.println("Input password");
        String password = s.nextLine();
        User user = userService.getUser(username, password);
        if (user != null) {
            System.out.println("Hi " + user.getFullName());
            new ProfessionMenuManager().manageProfession();
        } else {
            System.out.println("Please Enter valid username and/or password");
        }
    }

    public void manageExit() {
        System.out.println("Thank you, Good Bye");
    }

}
