package SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 4, 1, 3, 5, 0,0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int x : arr) {
            System.out.println(x + " ");
        }
    }
}
