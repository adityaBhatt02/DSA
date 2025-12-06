package Maths;

/*
It is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
so for eg :
153 -> 1^3 + 5^3 + 3^3 => 1 + 125 + 27 = 153
1634 -> 1^4 + 6^4 + 3^4 + 4^4 => 1 + 1296 + 81 + 256 = 1634


 */

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        int original = n;
        int length = String.valueOf(n).length();
        int sum = 0;

        while(n > 0) {
            int rem = n % 10;
            sum += (int) Math.pow(rem , length);
            n /= 10;
        }

        return original == sum;
    }
}
