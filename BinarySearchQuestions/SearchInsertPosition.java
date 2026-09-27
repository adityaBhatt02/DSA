/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
*/



class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length - 1;

        if(target > nums[n]) return n + 1;
        if(target < nums[0]) return 0;

        int result = search(nums, target);
        if(result != -1) return result;

        for(int i = 0 ; i <= n ; i++) {
            if(nums[i] > target) return i;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] > target) {
                end = mid - 1;
            }else if(nums[mid] < target) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
