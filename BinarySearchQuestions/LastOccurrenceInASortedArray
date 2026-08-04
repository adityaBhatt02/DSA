public class LastOccurrenceInASortedArray {
    static void main() {
        int[] arr = {3,4,13,13,13,13,20,40};                                                                      // o/p -> 5
        int target = 13;
        int res = result(arr, target);
        System.out.println(res);
    }

    static int result(int[] arr, int target) {
    int res = upperBound(arr, target) - 1;

    // if res is -1 is checked first becz if res is -1 then arr[res] -> arr[-1] boom error.
    if (res == -1 || arr[res] != target) return -1;

    return res;
    }

    static int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
