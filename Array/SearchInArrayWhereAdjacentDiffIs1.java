package Array;

/*
The array has the property:  arr[i+1] − arr[i] = 1
That means each step changes the value by exactly ±1.

Suppose you’re at index i and the current element is arr[i].
You are searching for x.

If arr[i] != x, then how far away in terms of value is it? -> d= arr[i]−x
That means the element you want is d numbers away in value.
 */

public class SearchInArrayWhereAdjacentDiffIs1 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 6, 5, 4, 3};;
        int target = 3;
        System.out.println(search(arr , target));
    }

    static int search(int[] arr , int target) {
        int i = 0;

        while(i < arr.length) {
            if(arr[i] == target) return i;       // found

            i += Math.abs(arr[i] - target);      // jump
        }
        return -1;
    }
}