/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.



Minimum Window Substring — Mental Model

Need to return the actual smallest window, so store both its size and its starting position.

Valid window
   ↓
(record its size → minLen
 record where it starts → start = left)
   ↓
shrink while still valid
   ↓
keep updating minimum

At the end:
s.substring(start, start + minLen)


minLen → HOW BIG?
start  → WHERE?

 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] tFreq = new int[128];
        for(int i = 0; i < t.length(); i++) tFreq[t.charAt(i)]++;

        int[] windowFreq = new int[128];

        int left = 0, right = 0, start = 0, count = 0, windowSize = 0, minSize = Integer.MAX_VALUE;

        while(right < s.length()) {
            windowSize++;

            char c = s.charAt(right);
            windowFreq[c]++;

 /* If the windowFreq have the current character frequency still smaller or equals to that of tFreq then it means its the
    character in "t" string but if it is larger it either means that current character is not in "t" string or we
    now have a duplicate in windowFreq so just dont increase "count" for it. */
            if(windowFreq[c] <= tFreq[c]) count++;


            while(count == t.length()) {
                if(windowSize < minSize) {      // If the problem only asked for the length of the minimum substring then we dont need "start" then just we will do -> Math.min(windowLength, minLength)
                    minSize = windowSize;
                    start = left;               // This is the beginning position of the smallest window I've found so far.
                }

                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;

/* After removing a frequency of the left character from the windowFreq if it is smaller than tFreq value for that leftChar
it simply means that we have removed a character that is in "t" string but not any more in our valid window so count-- and window is now invalid.

Or another case is that if the leftChar is actually the character which is in "t" string but we are having duplicate of it then
reducing its frequency doesnt give make the window invalid we still have a occurance(s) of that left character
So window in this case is still valid becz no count--  */
                if(windowFreq[leftChar] < tFreq[leftChar]) count--;

                windowSize--;
                left++;
            }

            right++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);              // Start at "start" till the size of the minWindow from "start"
    }
}