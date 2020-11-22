package Task;

import Task.model.Student;
import Task.service.StudentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Hayk_Avdalyan\\Desktop\\students.txt");
        String[] lines = Files.readAllLines(path).toArray(new String[0]);
        Student[] students = new Student[lines.length];

        for (int i = 0; i < lines.length; ++i) {
            String[] current = lines[i].split(",");
            students[i] = new Student(current[0], current[1], Integer.parseInt(current[2]), current[3], Double.parseDouble(current[4]));
        }

        StudentService ss = new StudentService();

        System.out.println("Task 1: Print full names of students");
        ss.printFullNames(students);
        System.out.println("\nTask 2: Print all male students");
        ss.printAllMales(students);
        System.out.println("\nTask 3: Print all female students who has mark greater then 50.4");
        ss.printAllFemalesGreaterThan50_4(students);
        System.out.println("\nTask 4: Print student information having the minimal mark");
        ss.printStudentWithMinimalMark(students);
        System.out.println("\nTask 5: Print biggest male student information");
        ss.printBiggestMaleInformation(students);
        System.out.println("\nTask 6: Print students sorted by mark");
        ss.printStudentSortedByMark(students);
        System.out.println("\nTask 7: Print female students sorted by year");
        ss.printFemaleSortedByYear(students);
    }
}
