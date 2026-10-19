/*
Reverse bits of a given 32 bits signed integer.

Example 1:
Input: n = 43261596
Output: 964176192

Explanation:
Integer	                Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000


Example 2:
Input: n = 2147483644
Output: 1073741822

Explanation:
Integer	                Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110


Constraints:
0 <= n <= 231 - 2
n is even.
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n = n >>> 1;
        }
        return result;
    }
}

/*
we are using for(int i = 0; i < 32; i++)

first i used while(n != 0)
The leading zeros are important! When reversing all 32 bits, those zeros move to the right side of the result.
But with while it loop stops as soon as n becomes zero, so it skips those leading zeros instead of adding them to the reversed result.

Why does for (i = 0; i < 32; i++) fix it?
It processes exactly 32 bits, even when n becomes zero before the loop finishes.

Once n becomes zero: n & 1  // 0

The algorithm keeps shifting result left and appending zeros, which correctly accounts for the original leading zeros.


Remember the difference:
Counting set bits: while (n != 0) works because you only need to count the 1s.
Reverse bits: process exactly 32 iterations because you must reverse all 32 bits, including zeros.
 */