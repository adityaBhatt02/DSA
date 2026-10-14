/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
*/

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int left = 0, right = 0, windowCount = 0, maxCount = 0;

        while(right < s.length()) {
            if(isVowel(s.charAt(right))) windowCount++;

            if(right - left + 1 == k) {
                maxCount = Math.max(windowCount, maxCount);

                if(isVowel(s.charAt(left))) windowCount--;

                left++;
            }
            right++;
        }
        return maxCount;
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
