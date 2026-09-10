/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        for(char c : p.toCharArray()) pFreq[c - 'a']++;
        
        int[] windowFreq = new int[26];
        int left = 0, right = 0, k = p.length();

        while(right < s.length()) {
            windowFreq[s.charAt(right) - 'a']++;

            if(right - left + 1 == k) {
                if(Arrays.equals(windowFreq, pFreq)) result.add(left);

                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
