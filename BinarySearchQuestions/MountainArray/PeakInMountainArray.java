package BinarySearchQuestions.MountainArray;

//Mountain array is also known as Bi-tonic array.(in which the array increases then started decreasing)

public class PeakInMountainArray {
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,4,3,2};
    int ans = peak(arr);
    System.out.println(ans);
    }

    static int peak(int[] arr) {
        int start = 0 , end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid + 1]) {                   // you are in descending part
                end = mid;
            }else {                                         // you are in ascending part
                start = mid + 1;
            }
        }
        return start;
}}


