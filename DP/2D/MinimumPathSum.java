/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all
numbers along its path.
Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */


/*
My approach defines: minimum cost before adding the current cell
minCost[i][j] = minimum cost before adding the current cell
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minCost = new int[m][n];
        minCost[0][0] = 0;

        for(int i = 1; i < n; i++) minCost[0][i] = minCost[0][i - 1] + grid[0][i - 1];
        for(int i = 1; i < m; i++) minCost[i][0] = minCost[i - 1][0] + grid[i - 1][0];

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                minCost[i][j] = Math.min(minCost[i - 1][j] + grid[i - 1][j], minCost[i][j - 1] + grid[i][j - 1]);
            }
        }

        return minCost[m - 1][n - 1] + grid[m - 1][n - 1];
    }
}