/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example:
Input: nums = [1,3,4,2,2]
Output: 2


Core idea: Treat the array like a linked list.
Given:

nums = [1, 3, 4, 2, 2]
index   0  1  2  3  4
Instead of moving normally with:

i++;
we move using:

i = nums[i];
So we get:

0 → 1 → 3 → 2 → 4 → 2 → 4 → 2...
This creates a cycle.

Why?

nums[2] = 4
nums[4] = 2

2 → 4 → 2 → 4...
The entrance of this cycle is the duplicate number → 2.

Then use Slow & Fast
Think of each array value as a next pointer:

slow = nums[slow];       // 1 step
fast = nums[fast];
fast = nums[fast];       // 2 steps
They eventually meet inside the cycle.

Then:

slow = nums[0];
Reset slow to the beginning.

Move both one step:

slow = nums[slow];
fast = nums[fast];
When they meet again, that node is the cycle entrance = duplicate number.
*/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];

            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
