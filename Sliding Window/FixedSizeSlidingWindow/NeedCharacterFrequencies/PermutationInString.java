/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freqS1 = new int[26];
        for(int i = 0; i < s1.length(); i++) freqS1[s1.charAt(i) - 'a']++;

        int left = 0, right = 0, k = s1.length();

        int[] freqS2 = new int[26];

        while(right < s2.length()) {
            char currentChar = s2.charAt(right);
            freqS2[currentChar - 'a']++;

            if(right - left + 1 == k) {
                if(Arrays.equals(freqS1, freqS2)) return true;

                freqS2[s2.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return false;
    }
}