package Maths;

public class PalindromeNumber {
        public boolean isPalindrome(int x) {
            if(x < 0) return false;

            int rev = reverse(x , 0);
            return x == rev;
        }

        public int reverse(int num , int rev) {
            if(num == 0) return rev;

            int rem = num % 10;
            return reverse(num/10 , rev * 10 + rem);
        }
    }
