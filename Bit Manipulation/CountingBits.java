
/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the
binary representation of i.

Do not solve it with built-in functions (i.e., like __builtin_popcount in C++).

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:
0 <= n <= 105
 */

// O(n) time complexity only
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 0; i < result.length; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
        }
    }
}


// O(n logn) time complexity
class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 0; i < result.length; i++) {
            int count = 0, num = i;

            while(num != 0) {
                count += num & 1;
                num = num >>> 1;
            }

            result[i] = count;
        }
        return result;
    }
}