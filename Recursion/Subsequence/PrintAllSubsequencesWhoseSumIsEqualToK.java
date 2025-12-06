package Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesWhoseSumIsEqualToK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        subseq(0 , arr , list , 0 , k);
        System.out.println();
        System.out.println();
        onlyOneSubseq(0,arr,list,0,k);
    }

    static void subseq(int index , int[] arr , List<Integer> list , int sum , int target) {
        /*
        just keep this is mind that every subsequence made is after take or not approach then when the
        index is equal or greater than the array's length its made.
        (so every subsequence basically pair like sum and all is made when index == arr.length;
         */
        if(index >= arr.length) {
            if(sum == target) {
                System.out.println(list);
                return;
            }
            return;
        }

        //take it
        list.add(arr[index]);
        subseq(index + 1 , arr , list , sum + arr[index] , target);

        //not take it
        list.removeLast();
        subseq(index + 1 , arr , list , sum , target);
    }

    static boolean onlyOneSubseq(int index , int[] arr , List<Integer> list , int sum , int target) {
        if(index >= arr.length) {
            if(sum == target) {
                System.out.println(list);
                return true;
            }
            return false;
        }

        //take it
        list.add(arr[index]);
        if(onlyOneSubseq(index + 1, arr, list, sum + arr[index], target)) return true;

        //not take it
        list.removeLast();
        return onlyOneSubseq(index + 1, arr, list, sum, target);
    }
}
