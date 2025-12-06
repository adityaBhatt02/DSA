package Maths;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);               // if the number is -ve then make it +ve
        int reversed = helper(x, 0);            // then normal rev
        return isNegative ? -reversed : reversed;      // if the number was -ve just add (-) in front of the reversed number.
    }

    private int helper(int num, int rev) {
        if (num == 0) return rev;

        int rem = num % 10;
        if (rev > (Integer.MAX_VALUE - rem) / 10) return 0; // prevent overflow

        return helper(num / 10, rev * 10 + rem);
    }
}
/*
In Java the range of integer is -2,147,483,648  to  2,147,483,647

rev * 10 + rem <= Integer.MAX_VALUE    {choti honi chahiye wrna overflow hojaega}
rev <= (Integer.MAX_VALUE - rem)/10    {just islolate rev}

bss yhi hae and if its overflow then the rev will be greater than (Integer.MAX_VALUE - rem)/10 and then further multiplying it by 10
causes more overflow so just return 0 at that point.
 */