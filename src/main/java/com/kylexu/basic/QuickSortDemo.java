package com.kylexu.basic;

import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(a, lo, hi);
        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);
    }

    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];

        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }
}
