package Greedy;

// [2,3,1,1,4]
// [3,2,1,0,4]

public class JumpGame {
        /*
        nums[i] + i will give the max length if max length is equal to the arrays length - 1 or extends over the array it means it can reach the end so return true if
        there is 0 in b/w then it will stop there and will never reaches the end isliye if the i exceeds the maxLength means 0 is present so return false.
       */
        public boolean canJump(int[] nums) {
            int maxLength = 0;
            for(int i = 0 ; i < nums.length ; i++) {
                if(i > maxLength) return false;

                maxLength = Math.max(maxLength , i + nums[i]);

                if(maxLength >= nums.length - 1) return true;
            }
            return false;
        }
}
