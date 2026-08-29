import java.util.*;

public class MSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;            // Base Condition

        int mid = left + (right - left)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;                 // left half pointer
        int j = mid + 1;             // right half pointer
        int k = 0;                  // temp array pointer

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(int x = 0; x < temp.length; x++) arr[left + x] = temp[x];
    }
}