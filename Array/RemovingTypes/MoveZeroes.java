package Array.RemovingTypes;

//  move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.
public class MoveZeroes {
        public void moveZeroes(int[] nums) {
            int k = 0;                        // k only chalaya for non zero.
            for(int num : nums) {
                if(num != 0) {
                    nums[k] = num;
                    k++;
                }
            }

            while(k < nums.length) {
                nums[k] = 0;
                k++;
            }
        }
    }


    // 2 0 5 6 0 1 3