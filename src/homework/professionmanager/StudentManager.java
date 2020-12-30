package homework.professionmanager;

import homework.myProject.service.StudentService;

import java.util.Scanner;

public class StudentManager implements ProfessionManager {

    @Override
    public void manage() {
        StudentService student = StudentService.getInstance();
        boolean isStudentActive = true;
        Scanner s = new Scanner(System.in);
        while (isStudentActive) {
            System.out.println("1. Add Student");
            System.out.println("2. Print Full Names");
            System.out.println("3. Print All Females");
            System.out.println("4. Print All Males");
            System.out.println("5. Print all female students who has mark greater than 50");
            System.out.println("6. Print all male students who has mark greater than 50");
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
                    isStudentActive = false;
                    break;
                default:
                    System.out.println("Invalid case");
            }
        }
    }
}
