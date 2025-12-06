package BinarySearchQuestions.MountainArray;

public class TargetInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4,3,2};
        int target = 5;
        int ans = find(arr , target);
        System.out.println(ans);
    }

    static int find(int[] arr , int target) {
        int peak = peakIndex(arr);

        if(arr[peak] == target) return peak;

        int asc = orderAgnosticBs(arr , target , 0 , peak);
        if(asc != -1) {
            return asc;
        }
        return orderAgnosticBs(arr , target , peak+1 , arr.length - 1);
    }


    static int peakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }


    static int orderAgnosticBs(int[] arr , int target , int start , int end) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if(arr[mid] > target) {
                    end = mid - 1;
                } else if(arr[mid] < target) {
                    start = mid + 1;
                }
            }else {
                if(target > arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
