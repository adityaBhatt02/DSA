/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
A permutation means: all possible arrangements / orders of the elements.

For example:
nums = [1, 2, 3]
Its permutations are:

[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
There are 6 because: 3 × 2 × 1 = 6

Combination      → choose forward
Combination Sum  → choose forward, reuse with i
Permutation      → choose ANY unused element
*/


// This appraoch is also good but boolean array one is more better optimal solution
class Permutation2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        if(currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(currentList.contains(nums[i])) continue;                       // contains check every element in the list so Java take O(n) time in every recursion call

            currentList.add(nums[i]);
            backtrack(nums, currentList, result);
            currentList.removeLast();
        }
    }
}

// Boolean array appraoch is 1 ms faster than the list.contains approach becz its not checking n times in every recursive call it checks directly for that index,
// in our used boolean array if it is used or not for that recursive call
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> currentList, List<List<Integer>> result) {
        if(currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            currentList.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, currentList, result);

            currentList.removeLast();
            used[i] = false;
        }
    }
}
