/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

In CombinationSum 1 there were no duplicate elements in the array but in CombinationSum2 there can be duplicates
 */

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i > index && candidates[i] == candidates[i - 1]) continue;

            currentList.add(candidates[i]);
            backtrack(i + 1, candidates, currentList, result, target - candidates[i]);
            currentList.removeLast();
        }
    }
}