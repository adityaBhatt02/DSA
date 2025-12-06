package Array;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] result = new int[nums.length];

            for(int i = 0 ; i < nums.length ; i++) {
                int count = 0;
                for (int num : nums) {
                    if (nums[i] > num) count++;
                }
                result[i] = count;
            }
            return result;
        }
    }

