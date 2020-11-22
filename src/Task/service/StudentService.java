package Task.service;

import Task.model.Student;

public class StudentService {
    public void printFullNames(Student[] students) {
        for (Student student : students) {
            System.out.println("Full Name - " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void printAllMales(Student[] students) {
        for (Student student : students) {
            if (student.getGender().equals("m")) {
                System.out.println(student);
            }
        }
    }

    public void printAllFemalesGreaterThan50_4(Student[] students) {
        for (Student student : students) {
            if (student.getGender().equals("f") && student.getMark() > 50.4) {
                System.out.println(student);
            }
        }
    }

    public void printStudentWithMinimalMark(Student[] students) {
        Student min = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMark() < min.getMark()) {
                min = students[i];
            }
        }
        System.out.println(min);
    }

    public void printBiggestMaleInformation(Student[] students) {
        Student biggestMale = null;
        int year = 5000;
        for (int i = 0; i < students.length; ++i) {
            if (students[i].getYear() < year && students[i].getGender().equals("m")) {
                biggestMale = students[i];
                year = students[i].getYear();
            }
        }
        if (year != 0) {
            System.out.println(biggestMale);
        } else {
            System.out.println("There is not male student");
        }
    }

    public void printStudentSortedByMark(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getMark() > students[j].getMark()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printFemaleSortedByYear(Student[] students) {
        boolean flag = false;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getYear() > students[j].getYear()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (Student student : students) {
            if (student.getGender().equals("f")) {
                System.out.println(student);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("There is not female student");
        }
    }

}
