package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 */

public class SetMismatch {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            int maxSum = n*(n+1)/2;
            List<Integer> result = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            for(int num : nums) {
                if(!set.add(num)) {
                    result.add(num);
                }
            }

            int currentSum = 0;
            for(int num : set) {
                currentSum += num;
            }

            result.add(maxSum - currentSum);
            return result.stream().mapToInt(i -> i).toArray();
        }
    }
