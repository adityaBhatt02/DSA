package Recursion.Combinations;

import java.util.ArrayList;
import java.util.List;

/*
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

an element can be used multiple times. like 2 is used here.
 */

public class CombinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            combinations(0 , target , new ArrayList<>() , result , candidates);
            return result;
        }

        public void combinations(int index , int target , List<Integer> current , List<List<Integer>> result , int[] nums) {
            if(target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }

            if(index >= nums.length || target < 0) return;

            // pick ->
            current.add(nums[index]);
            combinations(index , target - nums[index] , current , result , nums);

            // not pick ->
            current.removeLast();
            combinations(index + 1 , target , current , result , nums);
        }
}
