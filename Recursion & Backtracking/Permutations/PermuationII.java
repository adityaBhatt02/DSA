/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class PermuationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;           // already used that element

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;           // checking for duplicate in the same branch. If they are in the same branch so dont skip it if they are of different branch skip it

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, current, result);

            current.removeLast();
            used[i] = false;
        }
    }
}