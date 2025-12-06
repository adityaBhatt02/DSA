package Array;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
 */

public class ShuffleArray {
        public int[] shuffle(int[] nums, int n) {
            int[] result = new int[nums.length];
            int j = 0;

            for(int i = 0 ; i < n ; i++) {
                result[j++] = nums[i];
                result[j++] = nums[n + i];
            }
            return result;
        }
    }

