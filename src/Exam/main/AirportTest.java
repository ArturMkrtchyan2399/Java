package Exam.main;

import Exam.model.Plane;
import Exam.service.PlaneService;

import java.util.Scanner;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService pl = new PlaneService();

        Plane pl0 = pl.create();
        Plane pl1 = pl.create();
        Plane pl2 = pl.create();
        Plane[] planes = {pl1, pl2, pl0};
        pl.informationAboutPlane(pl1);
        pl.infoAboutMilitaryPlane(pl2);
        pl.whichPlaneIsNewer(pl0, pl2);
        pl.whichPlaneHasBiggerWingspan(pl1, pl2);
        pl.whichPlaneHasHighestCost(pl2, pl1, pl0);
        pl.whichPlaneWithSmallestSeatsCount(pl1, pl2, pl0);
        pl.printNotMilitaryPlanes(planes);
        pl.printAllMilitaryPlanesWithMoreThan100Hours(planes);
        pl.printPlaneWithMinimalWeight(planes);
        pl.planeWithMinimalCost(planes);
        pl.printAscendingByYear(planes);
        pl.printDescendingByNumberOfSeats(planes);

    }
}
