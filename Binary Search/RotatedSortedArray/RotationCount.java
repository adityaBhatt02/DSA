package BinarySearchQuestions.RotatedSortedArray;


// logic - jitna bhi pivot hoga uska +1 is how many times the array got rotated.
/* so no. of elements before and including the pivot is total no. of rotation count in a rotated sorted array.
for eg: {5,6,7,8,0,1,2} so rotation count in this array will be 4 becz(pivot is 8 and elements before it are 3 so total rotation including 8 will be 4).....
 */


public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,0,1,2};
        int pivot = findPivot(arr);

//        int count = 0;
//        for (int i = 0; i <= pivot; i++) {
//            count++;
//        }                                     or

        int count = pivot + 1;                          // jitna bhi pivot hoga uska +1 is how many times the array got rotated.
        System.out.println(count);
    }


    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            }
            if (arr[start] < arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
