package Algorithm;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // ... do something ...
        int n = 100000;
        int[] test = new int[n];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 1000000);
        }
        bubbleSort(test);
        System.out.println(Arrays.toString(test));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}