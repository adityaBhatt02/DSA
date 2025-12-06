package Array;

import java.util.Arrays;

/*
eg->
nums = [3,30]
o/p -> "330" not "303"

so we first convert every element on nums array to String then store them in String array.
Then we sort elements inside the String array using our custom comparator that a + b gives bigger value
or b + a.
Then just create a StringBuilder traverse through the String array which is now sorted according to us
then just append them in the StringBuilder.
 */

public class LargestNumber {
        public String largestNumber(int[] nums) {
            String[] strNum = new String[nums.length];

            for(int i = 0 ; i < nums.length ; i++) {
                strNum[i] = String.valueOf(nums[i]);        // converts each element of int to String.
            }

            Arrays.sort(strNum , (a , b) -> (b + a).compareTo(a + b));            // bigger concatenation first descending order

            if(strNum[0].equals("0")) return "0";          // just an edge case when after sorting 0 is at first it means array only contains "0"

            StringBuilder result = new StringBuilder();
            for(String str : strNum) {
                result.append(str);
            }

            return result.toString();
        }
}
