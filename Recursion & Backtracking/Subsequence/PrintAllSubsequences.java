package Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;

/*
 contagious/non-contagious part of the array that follows the order is called a subsequence of that array.
empty array {} is also a subsequence.
 */
public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<Integer> list = new ArrayList<>();
        subseq(0 , arr , list);
    }

    static void subseq(int index , int[] arr , List<Integer> list) {
        if(index >= arr.length) {
            System.out.println(list);
            return;
        }

        // take it
        list.add(arr[index]);
        subseq(index + 1 , arr , list);

        // not take it (backtrack by removing last added element)
        list.removeLast();
        subseq(index + 1 , arr , list);
    }
}
