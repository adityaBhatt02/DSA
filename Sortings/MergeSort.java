package Sortings;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,9,7,3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int middle = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr , 0 , middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middle , arr.length));

        return merge(left , right);
    }

    static int[] merge(int[] left , int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                mergedArray[k] = left[i];
                i++;
                k++;
            }
            else {
                mergedArray[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            mergedArray[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            mergedArray[k] = right[j];
            j++;
            k++;
        }
        return mergedArray;
    }
}
