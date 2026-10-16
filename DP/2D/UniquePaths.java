/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to
move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.


Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */

// Time - O(mn) and Space - O(mn)
public class UnqiuePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {           //(Base Case) - if either row is 0 or col is 0 means there is only 1 total ways to reach that cell (becz a robot can move either right or down)
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];          //(Transition) - to reach a particular cell (i,j) the robot can either come either from the top (i-1 ,j) or from the left (i, j-1) of that cell .. top becz robot can move down , left becz robot can move right
                }
            }
        }

        return dp[m - 1][n - 1];       // becz the question is asking to return total number of ways to reach the last cell of the grid
    }
}