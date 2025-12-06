package Sortings;

import java.util.Arrays;

// what pivot to choose -> random element , last(corner element) , middle element.           middle is the best
// O(nlogn) best and O(n^2) worst.
public class QuickSort {
    public static void main(String[] args) {
        int[] arr  = {5,4,3,2,1};
        sort(arr , 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // low and high => tells which part of the array you are working on.                   ,  start and end => are just for swapping
    static void sort(int[] arr , int low , int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int m = start + (end - start) / 2;
        int pivot = arr[m];

        while (start <= end) {

            //also a reason why if its already sorted it will not swap(thats why quick sort is preferred over merge sort for arrays and stuff)
            while(arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }

            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // now my pivot is at correct index , please sort two halves now
        sort(arr , low , end);
        sort(arr , start , high);

    }

}
