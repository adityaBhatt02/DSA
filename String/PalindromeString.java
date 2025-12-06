package String;

/*
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

public class PalindromeString {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^A-Za-z0-9]" , "");           // string s is alphanumeric
            s = s.toLowerCase();

            char[] c = s.toCharArray();
            int start = 0 , end = c.length - 1;

            while(start < end) {
                if(c[start] != c[end]) return false;
                start++;
                end--;
            }
            return true;
        }
    }