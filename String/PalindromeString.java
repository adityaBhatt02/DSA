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

    // O(1) space complexity, just skipping those characters which are not alphanumeric.
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }
        return true;
    }


// This approach is simple but taking O(n) space complexity by creating the character array of size n(size of the string)
//        public boolean isPalindrome(String s) {
//            s = s.replaceAll("[^A-Za-z0-9]" , "");           // string s is alphanumeric
//            s = s.toLowerCase();
//
//            char[] c = s.toCharArray();
//            int start = 0 , end = c.length - 1;
//
//            while(start < end) {
//                if(c[start] != c[end]) return false;
//                start++;
//                end--;
//            }
//            return true;
//        }
    }