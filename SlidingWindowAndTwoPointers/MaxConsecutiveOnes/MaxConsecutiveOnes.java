package SlidingWindowAndTwoPointers.MaxConsecutiveOnes;

//  [1,1,0,1,1,1] -> 3
// [1,0,1,1,0,1] -> 2
public class MaxConsecutiveOnes {
        public int longestOnes(int[] nums, int k) {
            int r = 0 , currentLength = 0 , maxLength = 0;

            while(r < nums.length) {
                if(nums[r] == 0) {
                    currentLength = 0;
                }else{
                    currentLength++;
                    maxLength = Math.max(currentLength , maxLength);
                }
                r++;
            }
            return maxLength;
        }
    }