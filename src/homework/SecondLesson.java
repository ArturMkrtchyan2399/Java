package homework;


public class SecondLesson {
    public static void main(String[] args) {
        System.out.println("Task 1\nCreate an array and fill it with 2 number.");
        int[] arr1 = {2, 2, 2, 2, 2, 2, 2, 2};

        System.out.println("Task 2\nCreate an array and fill it with numbers from 1:1000.");
        int[] arr2 = new int[1000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println("Task 3\nCreate an array and fill it with odd numbers from -20:20");
        int[] arr3 = new int[20];
        for (int i = 0, j = -19; i < arr3.length; i++, j += 2) {
            arr3[i] = j;
        }

        System.out.println("Task 4\nCreate an array and fill it. Print all elements which can be divided by 5.");
        int[] arr4 = {12, 4, 5, 10, 6, 25, 60, 13, 70, 100, 50, 40};
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] % 5 == 0) {
                System.out.println(arr4[i]);
            }
        }

        System.out.println("Task 5\nCreate an array and fill it. Print all elements which are between 24.12 and 467.23.");
        double[] arr5 = {12.4, 24.8, 567.45, 76.6, 98.43, 45.56};
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > 24.12 && arr5[i] < 467.23) {
                System.out.println(arr5[i]);
            }
        }

        System.out.println("Task 6\nCreate an array and fill it. Print count of elements which can be divided by 2.");
        int[] arr6 = {2, 4, 5, 7, 12, 7677, 23, 54, 789, 232, 56, 78, 34};
        int count = 0;
        for (int i = 0; i < arr6.length; i++) {
            if (arr6[i] % 2 == 0) {
                ++count;
            }
        }
        System.out.println(count);

        System.out.println("Task 7\nEach multiple N x i (where 0<i<11) should be printed on a new line in the form: N x i = result.");
        int N = 14;
        for (int i = 1; i <= 10; ++i) {
            System.out.println(N + " x " + i + " = " + N * i);
        }
    }
}
