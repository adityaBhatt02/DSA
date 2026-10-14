package SlidingWindowAndTwoPointers;

public class MaxSum {
    public static void main(String[] args) {
    int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
    int k = 4;
    System.out.println(max(arr, k));
}

    static int max(int[] arr , int k) {
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;

        for (int i = 0 ; i < k ; i++) {
            lsum = lsum + arr[i];
        }
        maxSum = lsum;

        int rindex = arr.length - 1;
        for(int i = k - 1 ; i >= 0 ; i--) {
            lsum = lsum - arr[i];
            rsum = rsum + arr[rindex];
            maxSum = Math.max(maxSum , lsum + rsum);
            rindex = rindex - 1;
        }

        return maxSum;
    }
}
