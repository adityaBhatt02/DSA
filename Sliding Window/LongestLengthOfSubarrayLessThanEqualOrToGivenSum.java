package SlidingWindowAndTwoPointers;

public class LongestLengthOfSubarrayLessThanEqualOrToGivenSum {
    public static void main(String[] args) {
        int k = 14;
        int[] arr = {4,2,1,4,3,9,2};
        System.out.println(longestLengthOfSubarray(arr , k));
    }

    private static int longestLengthOfSubarray(int[] arr , int k) {
       int l = 0 , r = 0 , sum = 0, maxLength = 0;
       while(r < arr.length) {
           sum += arr[r];

           while(sum > k) {
               sum -= arr[l];
               l += 1;
           }
           if(sum <= k) {
               maxLength = Math.max(maxLength , r-l+1);
               r += 1;
           }
       }
       return maxLength;
    }
}
