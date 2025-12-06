package SlidingWindowAndTwoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

        public static int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left = 0, right = 0;
            int maxLen = 0;

            while (right < s.length()) {
                char currentChar = s.charAt(right);

                // If character already seen, shrink window from left
                while (set.contains(currentChar)) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(currentChar);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }

            return maxLen;
        }

        public static void main(String[] args) {
            String s = "pwwkew";
            System.out.println("Longest length: " + lengthOfLongestSubstring(s));  // Output: 3 ("wke")
        }
    }

