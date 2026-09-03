package Greedy;

/*
ques is minimum number of jumps it takes to reach the end.
eg- nums = [2,3,1,1,4]
Output: 2

-jump is how many jumps you have taken and that is what we have to return.
-currentEnd is the last index of the element for the current window.
-farthest is , like for every element's index it is checked and only the farthest one get stored in it.
 */

public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        
        int jump = 0 , currentEnd = 0 , maxReach = 0;

        for(int i = 0 ; i < nums.length - 1 ; i++) {
            maxReach = Math.max(maxReach , nums[i] + i);

            if(currentEnd == i) {
                jump++;
                currentEnd = maxReach;

                if(currentEnd >= nums.length - 1) break;
            }
        }
        return jump;
    }
}

