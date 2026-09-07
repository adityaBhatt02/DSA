/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Example 1:
Input: s = "42"
Output: 42

Example 2:
Input: s = " -042"
Output: -42

Example 3:
Input: s = "1337c0d3"
Output: 1337

Example 4:
Input: s = "0-1"
Output: 0

Example 5:
Input: s = "words and 987"
Output: 0


Approach --->
Its a very simple problem just keep couple of things in mind that ->
1) remove all whitespaces from front and end.
2) +42 and 42 are both positives but valid input can be +42 as well given so answer will be in + at front and -42 is yeah answer will be in -ve.
3) If you see any non digit character in between just come out of the loop.

4) very very imp thing now, as we know in java ->
Integer.MAX_INTEGER = 2147483647   and    Integer.MIN_INTEGER = -2147483648

if we try to do something like int x = 2147483647 + 1 then output will be -2147483648 thats called wrap around.
similarly, x = -2147483648 - 1  o/p will be 2147483647 (same wrap around here too).

so in the question we are told that whenever your result is overflowing Integer.MAX_INTEGER or Integer.MIN_INTEGER (means overflowing int)
then just return according to the sign at first for +ve Integer.MAX_INTEGER and for -ve Integer.MIN_INTEGER
 */


public class StringToInteger(atoi) {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0) return 0;

        int sign = 1, i = 0;

        if(s.charAt(i) == '-' || s.charAt(0) == '+') {
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }

        int result = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            if(result > (Integer.MAX_VALUE - digit) / 10) {                     // before multiply by 10 and adding the digit we are doing its reverse with Integer.MAX_VALUE to check first that the result will overflow int or not
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}