package Classwork;

public class classwork {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 12, 16, 3, 4, 86, 64, 77, 32, 1};
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            while (x != 1) {
                if (x % 2 == 1) {
                    break;
                }
                x /= 2;
            }
            if (x == 1) {
                System.out.println(arr[i]);
            }
        }
    }
}
