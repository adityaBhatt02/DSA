/*
Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an 
integer, return -1.

Example 1
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.

Example 2
Input: N = 4, M = 69
Output:-1
Explanation: The 4th root of 69 does not exist. So, the answer is -1.
*/

class Solution {
    public int NthRoot(int N, int M) {
        int start = 1, end = M;

        while(start <= end) {
            int mid = start + (end - start)/2;
            int pow = 1;

            for(int i = 1; i <= N; i++) {
                pow *= mid;
            }

            if(pow == M) {
                return mid;
            }else if(pow < M) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
