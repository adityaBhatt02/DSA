/*
You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
A substring is a contiguous sequence of characters within a string.

Example 1:

Input: num = "35420"
Output: "35"

Example 2:
Input: num = "4206"
Output: ""

Example 3:
Input: num = "35427"
Output: "35427"
 

Approach is that loop through from behind to front and then whenever you see an odd digit return the String from 0 till that index + 1 (becz in substring as we know the end is exclusive)
*/

public class LargestOddNumberInAString {
    public String largestOddNumber(String num) {
    
        for(int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if(digit % 2 != 0) return num.substring(0, i + 1);        
        }
        return "";
    }
}
