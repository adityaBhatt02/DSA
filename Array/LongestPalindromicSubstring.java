package Array;

public class LongestPalindromicSubstring {
        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) return "";

            String longest = "";

            for (int i = 0; i < s.length(); i++) {
                for (int j = i ; j < s.length(); j++) {
                    String sub = s.substring(i, j + 1);

                    if (isPalindrome(sub) && sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }

            return longest;
        }

        private boolean isPalindrome(String str) {
            int left = 0, right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }
    }
