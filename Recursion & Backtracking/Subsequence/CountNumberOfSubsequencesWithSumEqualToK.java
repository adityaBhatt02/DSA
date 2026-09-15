package Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfSubsequencesWithSumEqualToK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        System.out.println(subseq(0 , arr , list , 0 , k , 0));
    }

    static int subseq(int index , int[] arr , List<Integer> list , int sum , int target , int count) {
        if(index >= arr.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        //take it
        list.add(arr[index]);
        int left = subseq(index + 1 , arr , list , sum + arr[index] , target , count);

        //not take it
        list.removeLast();
        int right = subseq(index + 1 , arr , list , sum , target , count);

        return left + right;
    }
}
