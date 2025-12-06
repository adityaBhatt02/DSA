package Array.RemovingTypes;

/*
move all the even integers at the beginning of the array followed by all the odd integers.

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

eg: [2,3,5,4]
*/

public class SortByParity {
    public int[] sortArrayByParity(int[] nums) {                         // [3,1,2,4]
        if(nums.length <= 1) return nums;

        int left = 0 , right = nums.length - 1;

        while(left < right) {
            if(nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if(nums[left] % 2 == 0) left++;
            if(nums[right] % 2 == 1) right--;

        }
        return nums;                                                      // [4,2,1,3]
    }
}
