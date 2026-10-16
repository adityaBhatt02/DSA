/*
Time - O(n^2)
Space - O(1)

Why?
Your outer loop runs n times:

for (int i = 0; i < s.length(); i++) {
    int oddCount = oddLenPalindromes(i, s);
    int evenCount = evenLenPalindromes(i, s);
}

For every index, both helper methods can expand up to O(n) characters in the worst case.
For a string like "aaaaa", expansions can continue far from each center because the characters keep matching.
 */

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            int oddCount = oddLenPalindromes(i, s);
            int evenCount = evenLenPalindromes(i, s);

            count += oddCount + evenCount;
        }
        return count;
    }

    private int oddLenPalindromes(int index, String s) {
        int count = 1;                  // becz every single char is a odd length palindrome

        int left = index - 1;
        int right = index + 1;

        while(left >= 0 && right <= s.length() - 1) {
            if(s.charAt(left) != s.charAt(right)) return count;

            count++;

            left--;
            right++;
        }
        return count;
    }

    private int evenLenPalindromes(int index, String s) {
        int count = 0;

        int left = index;
        int right = index + 1;

        while(left >= 0 && right <= s.length() - 1) {
            if(s.charAt(left) != s.charAt(right)) return count;

            count++;

            left--;
            right++;
        }
        return count;
    }
}

// "abbac"  -> "a" "b" "bb" "abba" "b" "a" "c" -> 7


/*
Manacher's Algorithm is an advanced string algorithm that finds palindromes in
O(n) time. It's an optimized version of the Expand Around Center approach.

My solution, Expand Around Center takes O(n^2) time.
Manacher's avoids repeatedly checking characters that have effectively already been checked.
 */