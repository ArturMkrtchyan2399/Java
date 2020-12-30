package homework.myProject.service;

import homework.myProject.model.Human;

import java.util.List;

public class HumanService {

    public void printFullNames(List<? extends Human> humans) {
        if (humans.isEmpty()) {
            System.out.println("There is no humans in database");
            return;
        }
        for (Human human : humans) {
            System.out.println("Full Name - " + human.getFirstName() + " " + human.getLastName());
        }
    }

    public void printAllMales(List<? extends Human> humans) {
        if (humans.isEmpty()) {
            System.out.println("There is no humans in database");
            return;
        }
        for (Human human : humans) {
            if (human.getGender().equals("m")) {
                System.out.println(human);
            }
        }
    }

    public void printAllFemales(List<? extends Human> humans) {
        if (humans.isEmpty()) {
            System.out.println("There is no humans in database");
            return;
        }
        for (Human human : humans) {
            if (human.getGender().equals("f")) {
                System.out.println(human);
            }
        }

    }

}
