package Algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 100000;
        int[] test = new int[n];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 100000000);
        }
        mergeSort(test);
        System.out.println(Arrays.toString(test));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

    }

    public static void mergeSort(int[] data) {
        if (data.length > 2) {
            int[] left = Arrays.copyOfRange(data, 0, data.length / 2);
            int[] right = Arrays.copyOfRange(data, data.length / 2, data.length);
            mergeSort(left);
            mergeSort(right);

            merge(data, left, right);
        }
    }

    private static void merge(int[] data, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < data.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                data[i] = left[i1];
                i1++;
            } else {
                data[i] = right[i2];
                i2++;
            }
        }
    }
};