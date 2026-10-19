public class CountOccurrencesInSortedArray {
    static void main() {
        int[] arr = {2,2,3,3,3,3,4};
        int x = 4;

        System.out.println(result(arr, x));
    }

    static int result(int[] arr, int x) {
        int index = lowerBound(arr, x);
        if(index == arr.length || arr[index] != x) return 0;

        int count = 0;
        while(index < arr.length && arr[index] == x) {
            count++;
            index++;
        }
        return count;
    }

    static int lowerBound(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] >= x) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
