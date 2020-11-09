package Exam.service;

import Exam.model.Plane;

import java.util.Scanner;

public class PlaneService {
    public Plane create() {
        System.out.println("-----Create Plane-----");
        Scanner s = new Scanner(System.in);
        Plane plane = new Plane();
        System.out.println("Enter model");
        plane.setModel(s.nextLine());
        s.nextLine();
        System.out.println("Enter country");
        plane.setCountry(s.nextLine());
        s.nextLine();
        System.out.println("Enter publishing year");
        plane.setYear(s.nextInt());
        System.out.println("Enter hours in air");
        plane.setHours(s.nextInt());
        System.out.println("Enter true if plane is military, otherwise enter false");
        plane.setMilitary(s.nextBoolean());
        s.nextLine();
        System.out.println("Enter engine type");
        plane.setEngineType(s.nextLine());
        System.out.println("Enter weight");
        plane.setWeight(s.nextDouble());
        System.out.println("Enter wingspan");
        plane.setWingspan(s.nextInt());
        System.out.println("Enter top speed");
        plane.setTopSpeed(s.nextInt());
        System.out.println("Enter count of seats");
        plane.setSeats(s.nextInt());
        System.out.println("Enter cost");
        plane.setCost(s.nextDouble());
        return plane;
    }

    public void informationAboutPlane(Plane pl) {
        System.out.println("Model - " + pl.getModel() + "\n" +
                "Country - " + pl.getCountry() + "\n" +
                "Year - " + pl.getYear() + "\n" +
                "Hours - " + pl.getHours() + "\n" +
                "Military - " + pl.isMilitary() + "\n" +
                "EngineType - " + pl.getEngineType() + "\n" +
                "Weight - " + pl.getWeight() + "\n" +
                "Wingspan - " + pl.getWingspan() + "\n" +
                "TopSpeed - " + pl.getTopSpeed() + "\n" +
                "Seats - " + pl.getTopSpeed() + "\n" +
                "Cost - " + pl.getCost());
    }

    public void infoAboutMilitaryPlane(Plane pl) {
        if (pl.isMilitary()) {
            System.out.println("Cost - " + pl.getCost() + "\n" + "TopSpeed - " + pl.getTopSpeed());
        } else {
            System.out.println("Model - " + pl.getModel() + "\n" + "Country - " + pl.getCountry());
        }

    }

    public Plane whichPlaneIsNewer(Plane pl1, Plane pl2) {
        return pl1.getYear() == pl2.getYear() ? pl1 : pl1.getYear() > pl2.getYear() ? pl1 : pl2;

    }

    public String whichPlaneHasBiggerWingspan(Plane pl1, Plane pl2) {
        return pl1.getWingspan() == pl2.getWingspan() ? pl2.getModel() : pl1.getWingspan() > pl2.getWingspan() ? pl1.getModel() : pl2.getModel();
    }

    public Plane whichPlaneHasHighestCost(Plane pl1, Plane pl2, Plane pl3) {
        if (pl1.getCost() >= pl2.getCost() && pl1.getCost() >= pl3.getCost()) {
            return pl1;
        } else if (pl2.getCost() >= pl1.getCost() && pl2.getCost() >= pl3.getCost()) {
            return pl2;
        } else {
            return pl3;
        }
    }

    public void whichPlaneWithSmallestSeatsCount(Plane pl1, Plane pl2, Plane pl3) {
        if (pl1.getSeats() <= pl2.getSeats() && pl1.getSeats() <= pl2.getSeats()) {
            System.out.println(pl1.getCountry());
        } else if (pl2.getSeats() <= pl1.getSeats() && pl2.getSeats() <= pl3.getSeats()) {
            System.out.println(pl2.getSeats());
        } else {
            System.out.println(pl3.getSeats());
        }
    }

    public void printNotMilitaryPlanes(Plane[] pls) {
        for (Plane pl : pls) {
            if (!pl.isMilitary()) {
                informationAboutPlane(pl);
            }
        }
    }

    public void printAllMilitaryPlanesWithMoreThan100Hours(Plane[] pls) {
        for (Plane pl : pls) {
            if (pl.isMilitary() && pl.getHours() > 100) {
                informationAboutPlane(pl);
            }
        }
    }

    public Plane printPlaneWithMinimalWeight(Plane[] pls) {
        Plane result = pls[0];
        for (int i = 1; i < pls.length; ++i) {
            if (pls[i].getWeight() >= result.getWeight()) {
                result = pls[i];
            }
        }
        return result;
    }

    public Plane planeWithMinimalCost(Plane[] pls) {
        Plane result = pls[pls.length - 1];
        for (int i = pls.length - 2; i >= 0; --i) {
            if (pls[i].getCost() <= result.getCost()) {
                result = pls[i];
            }
        }
        return result;
    }

    public void printAscendingByYear(Plane[] pls) {
        for (int i = 0; i < pls.length - 1; i++) {
            for (int j = i + 1; j < pls.length; j++) {
                if (pls[i].getYear() > pls[j].getYear()) {
                    Plane temp = pls[i];
                    pls[i] = pls[j];
                    pls[j] = temp;
                }
            }
        }
        for (Plane p : pls) {
            informationAboutPlane(p);
        }

    }

    public void printDescendingByNumberOfSeats(Plane[] pls) {
        for (int i = 0; i < pls.length - 1; i++) {
            for (int j = i + 1; j < pls.length; j++) {
                if (pls[i].getSeats() > pls[j].getSeats()) {
                    Plane temp = pls[i];
                    pls[i] = pls[j];
                    pls[j] = temp;
                }
            }
        }
        for (int k = pls.length - 1; k >= 0; --k) {
            if (!pls[k].isMilitary()) {
                informationAboutPlane((pls[k]));
            }
        }
    }

}


