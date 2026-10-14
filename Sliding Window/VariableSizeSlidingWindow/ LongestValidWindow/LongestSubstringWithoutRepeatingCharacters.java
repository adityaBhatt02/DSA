/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, windowCount = 0, maxCount = 0;
        Set<Character> set = new HashSet<>();

        while(right < s.length()) {
            windowCount++;
            char currentChar = s.charAt(right);

            while(set.contains(currentChar)) {
                set.remove(s.charAt(left));
                windowCount--;
                left++;
            }

            set.add(currentChar);
            maxCount = Math.max(windowCount, maxCount);
            right++;
        }
        return maxCount;
    }
}