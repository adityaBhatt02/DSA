package SlidingWindowAndTwoPointers;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;        // no. of characters, we can replace.
        System.out.println(characterReplacement(s , k));
    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0 , maxFreq = 0 , maxLength = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq , freq[c - 'A']);

            /* main condition for the ques(just check current window size - the max of frequency of any character till now is smaller than the k(which is how many characters we can replace).
                so the logic is like simple that in a particular window there is maxFreq of one character for eg: 'A' then if we just remove those A from the array(or here you can say the window)
                then the remaining is what we need to replace then if those replacements are greater than k we can not do that so just shrink the window from the left and
                reduce the frequency of that element(character) from the left.
            */
            while((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength = Math.max(maxLength , r - l + 1);         // maxLength till now or the current length of the window.
        }
        return maxLength;
    }
}
