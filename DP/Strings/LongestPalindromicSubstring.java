public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            int odd = oddLenPalindromes(i, s);
            int even = evenLenPalindromes(i, s);

            if (odd > maxLen) {
                maxLen = odd;
                start = i - odd / 2;
            }

            if (even > maxLen) {
                maxLen = even;
                start = i - even / 2 + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int oddLenPalindromes(int index, String s) {
        int left = index;
        int right = index;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    private int evenLenPalindromes(int index, String s) {
        int left = index;
        int right = index + 1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

// "abbac" -> "a" "b" "bb" "abba" "a" "c" --> "abba"