/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.

Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:
Input: x = 3, y = 1
Output: 1
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int XOR = x ^ y;

        int result = 0;
        while(XOR != 0) {
            result += (XOR & 1);
            XOR = XOR >>> 1;
        }
        return result;
    }
}

/*
3 -> 0011
1 -> 0001        XOR = 0010 -> 2 -> count number of 1 bits in 2 -> 1
hamming distance = 1
*/