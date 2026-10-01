package SlidingWindowAndTwoPointers;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;        // no. of characters, we can replace.
        System.out.println(characterReplacement(s , k));
    }

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, windowSize = 0, maxSize = 0, maxFreq = 0;

        int[] freq = new int[26];

        while(right < s.length()) {
            windowSize++;

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while(windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;

                windowSize--;
                left++;
            }

            maxSize = Math.max(maxSize, windowSize);
            right++;
        }

        return maxSize;
    }
