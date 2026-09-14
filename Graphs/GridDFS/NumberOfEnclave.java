/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.


Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.


Same as SurroundedRegion question just here find land(i.e, 1) at boundaries of the grid and then dfs to all its neighbors
and then covert those into anything other than 1 like 0 or # your wish and then at last count number of 1's those are your
actual land that are covered by 0 and dont have a way to the boundary.
 */
public class NumberOfEnclave {
    private int rows, cols;

    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for(int i = 0; i < cols; i++) {
            if(grid[0][i] == 1) dfs(0, i, grid);
        }

        for(int i = 0; i < cols; i++) {
            if(grid[rows - 1][i] == 1) dfs(rows - 1, i, grid);
        }

        for(int i = 1; i < rows - 1; i++) {
            if(grid[i][0] == 1) dfs(i, 0, grid);
        }

        for(int i = 1; i < rows - 1; i++) {
            if(grid[i][cols - 1] == 1) dfs(i, cols - 1, grid);
        }

        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] grid) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;
        if(grid[row][col] != 1) return;

        grid[row][col] = 0;
        dfs(row - 1, col, grid);
        dfs(row + 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
    }
}