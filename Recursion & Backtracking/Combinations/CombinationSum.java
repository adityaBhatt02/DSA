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
        backtrack(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    private void backtrack(int index, int[] candidates, List<Integer> currentList, List<List<Integer>> result, int target) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }      

        for(int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(i, candidates, currentList, result, target - candidates[i]);
            currentList.removeLast();
        }
    }
}
